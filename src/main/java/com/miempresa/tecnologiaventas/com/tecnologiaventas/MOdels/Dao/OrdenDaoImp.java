package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Orden;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class OrdenDaoImp implements InterfaceCRUD<Orden>{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Orden> findAll() {
        return em.createQuery("from Orden").getResultList();
    }

    @Transactional
    @Override
    public void save(Orden orden) {
        System.out.println("***" + orden.getId());
        if (orden.getId() != null && orden.getId() > 0) {
            em.merge(orden);
            System.out.println("Actualizando detalle persistente");
        } else {
            em.persist(orden);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Orden findOne(Long id) {
        return em.find(Orden.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Orden orden = findOne(id);
        em.remove(orden);
    }
}
