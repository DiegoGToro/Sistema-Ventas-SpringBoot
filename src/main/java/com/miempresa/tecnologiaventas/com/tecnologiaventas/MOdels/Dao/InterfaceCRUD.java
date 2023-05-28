package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

public interface InterfaceCRUD<T> {
    public List<T>findAll();

    public void save(T Object);

    public T findOne(Long id);

    public void delete(Long id);
}
