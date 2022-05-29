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
import occ.ues.edu.sv.baches.entity.ObjetoEstado;

/**
 *
 * @author magdiel
 */
public class ObjetoEstadoBean extends AbstractDataAccess<ObjetoEstado>{

    @PersistenceContext (unitName = "bachesUP")
    EntityManager em;
    
    public ObjetoEstadoBean() {
        super(ObjetoEstado.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<ObjetoEstado> findAll() throws IllegalStateException {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
}
