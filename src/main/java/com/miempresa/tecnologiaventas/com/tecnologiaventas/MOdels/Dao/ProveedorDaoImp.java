package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Proveedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProveedorDaoImp implements InterfaceCRUD<Proveedor> {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Proveedor> findAll() {
        return em.createQuery("from Proveedor").getResultList();
    }

    @Override
    @Transactional
    public void save(Proveedor proveedor) {
        System.out.println("----" + proveedor.getId());
        if (proveedor.getId() != null && proveedor.getId() > 0) {
            em.merge(proveedor);
            System.out.println("Actualizando objeto persistente en la base de datos");
        } else {
            em.persist(proveedor);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor findOne(Long id) {
        return em.find(Proveedor.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Proveedor proveedor = findOne(id);
        em.remove(proveedor);    
    }    
}
