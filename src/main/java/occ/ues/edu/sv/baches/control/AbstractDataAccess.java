/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.control;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author magdiel
 * @param <T>
 */
public abstract class AbstractDataAccess<T> implements Serializable{
    protected final Class clase;

    public AbstractDataAccess(Class clase) {
        this.clase = clase;
    }

    public abstract EntityManager getEntityManager();

    public void crear(T nuevo) throws IllegalArgumentException, IllegalStateException {
        if (nuevo != null) {
            EntityManager em = null;
            try {
                em = getEntityManager();
            } catch (Exception e) {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
            if (em != null) {
                em.persist(nuevo);
                return;
            } else {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
        }
        throw new IllegalArgumentException();
    }

    public void eliminar(T registro) throws IllegalArgumentException, IllegalStateException {
        if (registro != null) {
            EntityManager em = null;
            try {
                em = getEntityManager();
            } catch (Exception e) {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
            if (em != null) {
                if (!em.contains(registro)) {
                    registro = em.merge(registro);
                }
                em.remove(registro);
                return;
            } else {
            }
        }
        throw new IllegalArgumentException();
    }

    public void modificar(T clase) throws IllegalArgumentException, IllegalStateException {
        if (clase != null) {
            EntityManager em = null;
            try {
                em = getEntityManager();
            } catch (Exception e) {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
            if (em != null) {
                em.merge(clase);
                return;
            } else {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
        }
        throw new IllegalArgumentException();
    }

    public T findById(Object id) throws IllegalArgumentException, IllegalStateException {
        if (id != null) {
            EntityManager em = null;
            try {
                em = getEntityManager();
            } catch (Exception e) {
            }
            if (em != null) {
                return (T) em.find(clase, id);
            } else {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
        }
        throw new IllegalArgumentException();
    }
    
    public List<T> findAll() throws IllegalStateException {
        EntityManager em = null;
        try {
            em = getEntityManager();
        } catch (Exception e) {
        }
        if (em != null) {
            TypedQuery q = this.GenerarConsultaBase(em);
            List salida = q.getResultList();

            if (salida != null) {
                return salida;
            } else {
                return Collections.EMPTY_LIST;
            }

        } else {
            throw new IllegalStateException("No se puede obtener un ambito de persistencia");
        }
    }
    
    public List<T> findRange(int first, int pageSize) throws IllegalArgumentException,IllegalStateException {
        if (first != 0 && pageSize != 0) {
            EntityManager em = null;
            try {
                em = getEntityManager();
            } catch (Exception e) {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
            if (em != null) {
                TypedQuery q = this.GenerarConsultaBase(em);
                q.setFirstResult(first);
                q.setMaxResults(pageSize);
                List<T> salida = q.getResultList();

                if (salida != null) {
                    return salida;
                } else {
                    return Collections.EMPTY_LIST;
                }
            } else {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public TypedQuery GenerarConsultaBase(EntityManager em) {
        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(clase);
            Root<T> raiz = cq.from(clase);
            cq.select(raiz);

            return em.createQuery(cq);
        } else {
            throw new IllegalArgumentException("No se puede obtener un ambito de persistencia");
        }
    }

    public Long contar() throws IllegalStateException {
        EntityManager em = null;
        try {
            em = getEntityManager();
        } catch (Exception e) {
        }
        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            cq.select(cb.count(cq.from(clase)));
            return em.createQuery(cq).getSingleResult();
        } else {
            throw new IllegalStateException("No se puede obtener un ambito de persistencia");
        }
    }
}

    