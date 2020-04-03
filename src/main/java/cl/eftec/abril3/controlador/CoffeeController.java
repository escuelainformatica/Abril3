
package cl.eftec.abril3.controlador;

import cl.eftec.abril3.entidades.Coffee;
import cl.eftec.abril3.mysql.CoffeeMysql;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    
    @Autowired
    CoffeeMysql coffeeMysql;
    
    @RequestMapping("/lista")
    public String listar(Model model) {
        List<Coffee> coffees=(List<Coffee>) coffeeMysql.findAll();
        
        model.addAttribute("coffees", coffees);
        
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
    
    /**
     * @PathVariable = obtiene los datos de la ruta.
     *             /@GetMapping("/order/{orderId}/receipts")
     *              funcion String (@PathVariable("orderId") int order)
     * @RequestParam = obtiene los datos despues de la ruta (despues de ?)
     *             /@GetMapping("/order/receipts") // /order/repeipts/?field=123
     *              funcion String (@RequestParam("field") int order)
     */
}
