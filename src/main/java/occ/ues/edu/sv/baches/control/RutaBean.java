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
import occ.ues.edu.sv.baches.entity.Ruta;

/**
 *
 * @author magdiel
 */
public class RutaBean extends AbstractDataAccess<Ruta>{

    @PersistenceContext (unitName = "bachesUP")
    EntityManager em;
    
    public RutaBean() {
        super(Ruta.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Ruta> findAll() throws IllegalStateException {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Ruta> findByName(String nombre){
        
        Query q=em.createNamedQuery("Ruta.findByNombre");
        q.setParameter("nombre", nombre);
        
        return q.getResultList();
    }
}

