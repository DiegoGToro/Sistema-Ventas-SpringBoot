package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao;

import java.util.List;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Usuario;

public interface IUsuarioDao {
    public List<Usuario>findAll(); //Listar cliente mostrar eliminar nos traera de la base de datos los clientes aca

    public void save(Usuario usuario);

    public Usuario findOne(Long id);

    public void delete(Long id);

    public void validar(Usuario usuario);
}
