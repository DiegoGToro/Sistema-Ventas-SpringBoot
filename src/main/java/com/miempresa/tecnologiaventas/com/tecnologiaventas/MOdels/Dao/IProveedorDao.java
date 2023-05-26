package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Proveedor;

public interface IProveedorDao {
    public List<Proveedor>findAll(); //Listar cliente mostrar eliminar nos traera de la base de datos los clientes aca

    public void save(Proveedor proveedor);

    public Proveedor findOne(Long id);

    public void delete(Long id);
}
