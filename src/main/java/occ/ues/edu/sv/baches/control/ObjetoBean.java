/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import occ.ues.edu.sv.baches.entity.Objeto;

/**
 *
 * @author magdiel
 */
public class ObjetoBean extends AbstractDataAccess<Objeto>{

    @PersistenceContext (unitName = "bachesUP")
    EntityManager em;
    
    public ObjetoBean() {
        super(Objeto.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Objeto> findAll() throws IllegalStateException {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Objeto> findByName(String nombre){
        
        Query q=em.createNamedQuery("Objeto.findByNombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }
    
    
}


