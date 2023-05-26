package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "proveedores", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String MarcaNombre, ProveedorNombre;
    private String Email, Password;
    private short CodigoRol=2;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMarcaNombre() {
        return MarcaNombre;
    }

    public void setMarcaNombre(String marcaNombre) {
        MarcaNombre = marcaNombre;
    }

    public String getProveedorNombre() {
        return ProveedorNombre;
    }

    public void setProveedorNombre(String proveedorNombre) {
        ProveedorNombre = proveedorNombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public short getCodigoRol() {
        return CodigoRol;
    }

    public void setCodigoRol(short codigoRol) {
        CodigoRol = codigoRol;
    }
}
