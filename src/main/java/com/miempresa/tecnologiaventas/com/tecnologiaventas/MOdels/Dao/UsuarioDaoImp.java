package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Usuario;

@Repository
public class UsuarioDaoImp implements InterfaceCRUD<Usuario> {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return em.createQuery("from Usuario where RolUsuario="+1+"").getResultList();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        System.out.println("----" + usuario.getId());
        if (usuario.getId() != null && usuario.getId() > 0) {
            em.merge(usuario);
            System.out.println("Actualizando objeto persistente en la base de datos");
        } else {
            em.persist(usuario);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findOne(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Usuario usuario = findOne(id);
        em.remove(usuario);
    }
}