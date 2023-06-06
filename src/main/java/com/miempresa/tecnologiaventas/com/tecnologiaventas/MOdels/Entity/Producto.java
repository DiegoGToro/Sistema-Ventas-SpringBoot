package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Producto: Un producto representa un artículo que se vende en el local de tecnología. Tiene un nombre, una descripción, un precio de venta, una cantidad en stock y un proveedor.
@Entity
@Table(name = "productos")
public class Producto implements Serializable  {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nombre, Descripcion;
    private Long Precio;
    private int Existencias;

    @ManyToOne()
    private Proveedor proveedor;
    
    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, Long precio, int existencias, Proveedor proveedor) {
        Id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        Precio = precio;
        Existencias = existencias;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Long getPrecio() {
        return Precio;
    }

    public void setPrecio(Long precio) {
        Precio = precio;
    }

    public int getExistencias() {
        return Existencias;
    }

    public void setExistencias(int existencias) {
        Existencias = existencias;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto [Id=" + Id + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Precio=" + Precio
                + ", Existencias=" + Existencias + ", proveedor=" + proveedor + "]";
    }
}
