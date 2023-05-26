package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductoDaoImp implements IProductoDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return em.createQuery("from Producto").getResultList();
    }

    @Transactional
    @Override
    public void save(Producto producto) {
        System.out.println("***" + producto.getId());
        if (producto.getId() != null && producto.getId() > 0) {
            em.merge(producto);
            System.out.println("Actualizando producto persistente");
        } else {
            em.persist(producto);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findOne(Long id) {
        return em.find(Producto.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Producto producto = findOne(id);
        em.remove(producto);
    }
}