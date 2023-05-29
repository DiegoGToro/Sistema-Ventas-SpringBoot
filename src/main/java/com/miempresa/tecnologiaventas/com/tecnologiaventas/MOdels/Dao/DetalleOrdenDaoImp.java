package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.DetalleOrden;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DetalleOrdenDaoImp implements InterfaceCRUD<DetalleOrden>{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<DetalleOrden> findAll() {
        return em.createQuery("from DetalleOrden").getResultList();
    }

    @Transactional
    @Override
    public void save(DetalleOrden detalle) {
        System.out.println("***" + detalle.getId());
        if (detalle.getId() != null && detalle.getId() > 0) {
            em.merge(detalle);
            System.out.println("Actualizando Detalle de orden persistente");
        } else {
            em.persist(detalle);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public DetalleOrden findOne(Long id) {
        return em.find(DetalleOrden.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        DetalleOrden detalle = findOne(id);
        em.remove(detalle);
    }
}
