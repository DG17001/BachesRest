/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.control;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import occ.ues.edu.sv.baches.entity.Ruta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

/**
 *
 * @author magdiel
 */
public class RutaBeanTest {
    
    public RutaBeanTest() {
    }

    /**
     * Test of crear method, of class RutaBean.
     */
    @Test
    public void testCrear() {
        System.out.println("crear");
        Ruta nuevo = new Ruta();
        RutaBean cut = new RutaBean();
        
        assertThrows(IllegalArgumentException.class, () -> {
            cut.crear(null);
        });
        
        assertThrows(IllegalStateException.class, () -> {
            cut.crear(nuevo);
        });
        
        EntityManager mockEM=Mockito.mock(EntityManager.class);
        cut.em=mockEM;
        cut.crear(nuevo);
        
        RutaBean espia=Mockito.spy(RutaBean.class);
        espia.em=mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(IllegalStateException.class);
        
                
        try {
            espia.crear(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of eliminar method, of class RutaBean.
     */
    @Test
    public void testEliminar() {
         System.out.println("eliminar");
        EntityManager mockEM=Mockito.mock(EntityManager.class);
        RutaBean cut = new RutaBean();
        cut.em=mockEM;
        
        Ruta eliminado=new Ruta();
        cut.eliminar(eliminado);
        
        Mockito.verify(mockEM,Mockito.times(1)).remove(ArgumentMatchers.any());
        
        try {
            cut.eliminar(null);
        } catch (IllegalArgumentException e) {
        }
        
        try {
            cut.eliminar(eliminado);
        } catch (IllegalStateException e) {
        }
    }

    /**
     * Test of modificar method, of class RutaBean.
     */
    @Test
    public void testModificar() {
        System.out.println("crear");
        Ruta nuevo = new Ruta();
        RutaBean cut = new RutaBean();
        
        assertThrows(IllegalArgumentException.class, () -> {
            cut.modificar(null);
        });
        
        assertThrows(IllegalStateException.class, () -> {
            cut.modificar(nuevo);
        });
        
        EntityManager mockEM=Mockito.mock(EntityManager.class);
        cut.em=mockEM;
        cut.modificar(nuevo);
        
        RutaBean espia=Mockito.spy(RutaBean.class);
        espia.em=mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(IllegalStateException.class);
        
                
        try {
            espia.modificar(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findById method, of class RutaBean.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
                
        EntityManager mockEM=Mockito.mock(EntityManager.class);
        RutaBean cut = new RutaBean();
        Ruta esperado=new Ruta();
        
        Mockito.when(mockEM.find(Ruta.class, id)).thenReturn(esperado);
        
        assertThrows(IllegalArgumentException.class, () -> {
            cut.findById(null);
        });
        
        assertThrows(IllegalStateException.class, () -> {
            cut.findById(id);
        });
        
        cut.em=mockEM;
        Ruta resultado=cut.findById(id);
        assertNotNull(resultado);
        assertEquals(esperado, resultado);
        
        RutaBean espia=Mockito.spy(RutaBean.class);
        espia.em=mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
                
        try {
            espia.findById(id);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findAll method, of class RutaBean.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        Root mockR = Mockito.mock(Root.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);

        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Mockito.any())).thenReturn(mockCQ);
        Mockito.when(mockCQ.from(Object.class)).thenReturn(mockR);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getResultList()).thenReturn(null);

        RutaBean cut = new RutaBean();

        assertThrows(IllegalStateException.class, () -> {
            cut.findAll();
        });

        RutaBean espia = Mockito.spy(RutaBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findAll();
        } catch (Exception e) {
        }

        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

        cut.em = mockEM;
        cut.findAll();

        Mockito.when(mockTQ.getResultList()).thenReturn(new ArrayList());
        cut.findAll();
    }

    /**
     * Test of findRange method, of class EstadoBean.
     */
    @Test
    public void testFindRange() {
        System.out.println("findRange");
        
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        Root mockR = Mockito.mock(Root.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Mockito.any())).thenReturn(mockCQ);
        Mockito.when(mockCQ.from(Object.class)).thenReturn(mockR);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getResultList()).thenReturn(null);
        
        RutaBean cut = new RutaBean();
        
        assertThrows(IllegalArgumentException.class, ()->{
            cut.findRange(0, 0);
        });
        
        assertThrows(IllegalStateException.class, ()->{
            cut.findRange(1, 2);
        });
        
        RutaBean espia = Mockito.spy(RutaBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findRange(1, 2);
        } catch (Exception e) {
        }

        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
        
        cut.em = mockEM;
        cut.findRange(1, 2);

        Mockito.when(mockTQ.getResultList()).thenReturn(new ArrayList());
        cut.findRange(1, 2);

    }

    /**
     * Test of contar method, of class RutaBean.
     */
    @Test
    public void testContar() {
        System.out.println("contar");
        Long esperado=Long.valueOf(1);
        
        EntityManager mockEM=Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB=Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ=Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ=Mockito.mock(TypedQuery.class);
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Long.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
        
        RutaBean cut = new RutaBean();
        
        assertThrows(IllegalStateException.class, () -> {
            cut.contar();
        });
        
        cut.em=mockEM;
        Long resultado = cut.contar();
        assertNotNull(resultado);
        assertEquals(esperado, resultado);
        
        RutaBean espia=Mockito.spy(RutaBean.class);
        espia.em=mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
                
        try {
            espia.contar();
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }
    
}
