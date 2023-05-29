package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Administrador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AdministradorDaoImp implements InterfaceCRUD<Administrador>{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Administrador> findAll() {
        return em.createQuery("from Administrador").getResultList();
    }

    @Override
    @Transactional
    public void save(Administrador administrador) {
        System.out.println("----" + administrador.getId());
        if (administrador.getId() != null && administrador.getId() > 0) {
            em.merge(administrador);
            System.out.println("Actualizando objeto persistente en la base de datos");
        } else {
            em.persist(administrador);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Administrador findOne(Long id) {
        return em.find(Administrador.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Administrador administrador = findOne(id);
        em.remove(administrador);
    }
}
