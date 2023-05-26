package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Producto;

public interface IProductoDao {
    public List<Producto>findAll();

    public void save(Producto producto);

    public Producto findOne(Long id);

    public void delete(Long id);
}
