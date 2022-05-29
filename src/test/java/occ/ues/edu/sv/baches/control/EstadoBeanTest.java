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
import occ.ues.edu.sv.baches.entity.Estado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

/**
 *
 * @author magdiel
 */
public class EstadoBeanTest {
    public EstadoBeanTest() {
    }

    /**
     * Test of crear method, of class EstadoBean.
     */
    @Test
    public void testCrear() {
        System.out.println("crear");
        Estado nuevo = new Estado();
        //Cloud Unit Testing
        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalArgumentException.class, () -> {
            cut.crear(null);
        });

        assertThrows(IllegalStateException.class, () -> {
            cut.crear(nuevo);
        });

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.crear(nuevo);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(IllegalStateException.class);

        try {
            espia.crear(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of eliminar method, of class EstadoBean.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EstadoBean cut = new EstadoBean();
        cut.em = mockEM;

        Estado eliminado = new Estado();
        cut.eliminar(eliminado);

        Mockito.verify(mockEM, Mockito.times(1)).remove(ArgumentMatchers.any());

        try {
            cut.eliminar(null);
        } catch (IllegalArgumentException e) {
        }

        try {
            cut.eliminar(eliminado);
        } catch (IllegalStateException e) {
        }

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(IllegalStateException.class);

        try {
            espia.eliminar(eliminado);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of modificar method, of class EstadoBean.
     */
    @Test
    public void testModificar() {
        System.out.println("crear");
        Estado nuevo = new Estado();
        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalArgumentException.class, () -> {
            cut.modificar(null);
        });

        assertThrows(IllegalStateException.class, () -> {
            cut.modificar(nuevo);
        });

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.modificar(nuevo);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(IllegalStateException.class);

        try {
            espia.modificar(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findById method, of class EstadoBean.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EstadoBean cut = new EstadoBean();
        Estado esperado = new Estado();

        Mockito.when(mockEM.find(Estado.class, id)).thenReturn(esperado);

        assertThrows(IllegalArgumentException.class, () -> {
            cut.findById(null);
        });

        assertThrows(IllegalStateException.class, () -> {
            cut.findById(id);
        });

        cut.em = mockEM;
        Estado resultado = cut.findById(id);
        assertNotNull(resultado);
        assertEquals(esperado, resultado);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);

        try {
            espia.findById(id);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findAll method, of class EstadoBean.
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

        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalStateException.class, () -> {
            cut.findAll();
        });

        EstadoBean espia = Mockito.spy(EstadoBean.class);
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
        
        EstadoBean cut = new EstadoBean();
        
        assertThrows(IllegalArgumentException.class, ()->{
            cut.findRange(0, 0);
        });
        
        assertThrows(IllegalStateException.class, ()->{
            cut.findRange(1, 2);
        });
        
        EstadoBean espia = Mockito.spy(EstadoBean.class);
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
     * Test of GenerarConsultaBase method, of class EstadoBean.
     */
    @Test
    public void testGenerarConsultaBase() {
        System.out.println("GenerarConsultaBase");
        EntityManager MockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder MockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery MockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        Root<Estado> MockR = Mockito.mock(Root.class);

        Mockito.when(MockEM.getCriteriaBuilder()).thenReturn(MockCB);
        Mockito.when(MockCB.createQuery(EstadoBean.class)).thenReturn(MockCQ);
        Mockito.when(MockCQ.from(EstadoBean.class)).thenReturn(MockR);
        Mockito.when(MockEM.createQuery(MockCQ.select(MockR))).thenReturn(mockTQ);

        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalArgumentException.class, () -> {
            cut.GenerarConsultaBase(null);
        });

        try {
            cut.GenerarConsultaBase(MockEM);
        } catch (Exception e) {
        }
    }

    /**
     * Test of contar method, of class EstadoBean.
     */
    @Test
    public void testContar() {
        System.out.println("contar");
        Long esperado = Long.valueOf(1);

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);

        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Long.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);

        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalStateException.class, () -> {
            cut.contar();
        });

        cut.em = mockEM;
        Long resultado = cut.contar();
        assertNotNull(resultado);
        assertEquals(esperado, resultado);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);

        try {
            espia.contar();
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }
}
