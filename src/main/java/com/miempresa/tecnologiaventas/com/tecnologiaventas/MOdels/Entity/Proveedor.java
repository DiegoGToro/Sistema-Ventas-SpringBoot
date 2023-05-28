package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "proveedores", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String ProveedorNombre;
    private String Email, Password;

    @OneToOne(mappedBy = "proveedor")
    private ContactoInfo contactoInfo;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
    
    public Proveedor() {
    }

    public Proveedor(Long id, String proveedorNombre, String email, String password, List<Producto> productos, ContactoInfo contactoInfo) {
        Id = id;
        ProveedorNombre = proveedorNombre;
        Email = email;
        Password = password;
        this.productos = productos;
        this.contactoInfo = contactoInfo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public ContactoInfo getContactoInfo() {
        return contactoInfo;
    }

    public void setContactoInfo(ContactoInfo contactoInfo) {
        this.contactoInfo = contactoInfo;
    }
}
