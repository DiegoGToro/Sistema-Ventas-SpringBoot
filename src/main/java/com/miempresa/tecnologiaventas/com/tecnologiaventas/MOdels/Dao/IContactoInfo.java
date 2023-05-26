package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.ContactoInfo;

public interface IContactoInfo {
    public List<ContactoInfo>findAll();

    public void save(ContactoInfo producto);

    public ContactoInfo findOne(Long id);

    public void delete(Long id);
}
