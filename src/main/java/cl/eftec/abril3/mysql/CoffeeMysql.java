
package cl.eftec.abril3.mysql;

import cl.eftec.abril3.entidades.Coffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Nota: Usualmente se usa el postfix crud, dao, dal, pero puede llamarse
 * como uno quiera (siempre que se entienda el contexto).
 * 
 * Nota: La anotacion @Repository no es necesario, ya que estamos extendiendo una clase
 * (herencia, es decir, usando todo lo de la clase crudrepository, y esta ya hereda esa anotacion
 * 
 * Que significay @Repository = son clases que usan o acceden a la base de datos.
 * Ademas, se pueden inyectar (usar autowired)
 * 
 * @author jorge
 */

@Repository
public interface CoffeeMysql extends CrudRepository<Coffee, Integer> {
    
    
    
}
