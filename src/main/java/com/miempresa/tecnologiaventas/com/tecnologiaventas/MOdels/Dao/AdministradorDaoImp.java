package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AdministradorDaoImp{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return em.createQuery("from Usuario where RolUsuario="+2+"").getResultList();
    }

    @Transactional
    public void save(Usuario administrador) {
        System.out.println("----" + administrador.getId());
        if (administrador.getId() != null && administrador.getId() > 0) {
            em.merge(administrador);
            System.out.println("Actualizando objeto persistente en la base de datos");
        } else {
            em.persist(administrador);
        }
    }

    @Transactional(readOnly = true)
    public Usuario findOne(Long id) {
        return em.find(Usuario.class, id);
    }

    @Transactional
    public void delete(Long id) {
        Usuario administrador = findOne(id);
        em.remove(administrador);
    }
}
