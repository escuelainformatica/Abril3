
package cl.eftec.abril3.controlador;

import cl.eftec.abril3.entidades.Coffee;
import cl.eftec.abril3.mysql.CoffeeMysql;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    
    @Autowired
    CoffeeMysql coffeeMysql;
    
    @RequestMapping("/lista") // localhost:8080/coffee/lista?mensaje=fedkdfkdfkdf&param=222
    public String listar(Model model
            ,@RequestParam(name= "mensaje",required = false) String mensaje
            ,@RequestParam(name= "mensaje2",required = false) String mensaje2) {
        List<Coffee> coffees=(List<Coffee>) coffeeMysql.findAll();
        
        model.addAttribute("coffees", coffees);
        model.addAttribute("mensaje",mensaje);
        
        return "coffee/lista";
    }
    
    
    /**
     * Recuerden: Si tenemos un formulario, es mejor separar las acciones en dos metodos:
     * Getmapping es cuando abrimos el formulario la primera vez.
     * Postmapping es despues de que realizamos alguna accion (click en boton)
    **/
    
    @GetMapping("/insertar")
    public String insertar(Model model) {
        Coffee objeto=new Coffee(); // partimos con un coffee vacio.
        model.addAttribute("objeto",objeto);
        return "coffee/insertar";
    }
    
    
    @PostMapping("/insertar")
    public String insertar(Model model,@ModelAttribute Coffee objeto) {

        // aqui debemos validar
        
        // e insertar
        coffeeMysql.save(objeto); // la funcion save sirve para insertar/actualizar.
        
        //model.addAttribute("objeto",objeto);
        //return "coffee/insertar";
        
        return "redirect:/coffee/lista"; // redireccionamos al listado.
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Model model,@PathVariable("id") int idCoffee) {
        Optional<Coffee> lectura=coffeeMysql.findById(idCoffee);
        if(lectura.isPresent()==false) {
            return "redirect:/coffee/lista?mensaje=no se encontro";
        }
        Coffee objeto=lectura.get();
        model.addAttribute("objeto",objeto);
        return "/coffee/editar";
    }
    
    @PostMapping("/editar")
    public String editar(Model model,@ModelAttribute Coffee objeto) {
        coffeeMysql.save(objeto); // insertar y modificar
        return "redirect:/coffee/lista"; // redireccionamos al listado.
    }
    
    @GetMapping("/borrar") // localhost:8080/coffee/borrar?idparam=2222
    public String borrar(@RequestParam("idparam") int idCoffee) {
        coffeeMysql.deleteById(idCoffee);
      
        return "redirect:/coffee/lista?mensaje=Elemento borrado";
    }
    
    
    
    
    /**
     * @PathVariable = obtiene los datos de la ruta.
     *             /@GetMapping("/order/{orderId}/receipts")
     *              funcion String (@PathVariable("orderId") int order)
     * @RequestParam = obtiene los datos despues de la ruta (despues de ?)
     *             /@GetMapping("/order/receipts") // /order/repeipts/?field=123
     *              funcion String (@RequestParam("field") int order)
     */
}
