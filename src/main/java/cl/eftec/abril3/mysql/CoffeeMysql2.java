/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.eftec.abril3.mysql;

import cl.eftec.abril3.entidades.Coffee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jorge
 */
@Repository
public class CoffeeMysql2 {
    

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void refresh(Coffee parkrunCourse) {
        em.refresh(parkrunCourse);
    }
    
    public List<Coffee> listar() {
        Query consulta=em.createQuery("select c from Coffee c");
        
        return consulta.getResultList();
        
    }

}
