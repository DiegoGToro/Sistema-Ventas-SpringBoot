package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.ContactoInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ContactoInfoImp implements InterfaceCRUD<ContactoInfo>{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<ContactoInfo> findAll() {
        return em.createQuery("from ContactoInfo").getResultList();
    }

    @Override
    @Transactional
    public void save(ContactoInfo contactoInfo) {
        System.out.println("----" + contactoInfo.getId());
        if (contactoInfo.getId() != null && contactoInfo.getId() > 0) {
            em.merge(contactoInfo);
            System.out.println("Actualizando objeto persistente en la base de datos");
        } else {
            em.persist(contactoInfo);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ContactoInfo findOne(Long id) {
        return em.find(ContactoInfo.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ContactoInfo contactoInfo = findOne(id);
        em.remove(contactoInfo);
    }
}
