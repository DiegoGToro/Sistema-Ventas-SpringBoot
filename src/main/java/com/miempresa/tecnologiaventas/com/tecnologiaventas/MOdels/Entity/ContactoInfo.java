package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity;

import java.io.Serializable;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_info")
public class ContactoInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "telefono", nullable = false)
    private String Telefono;

    @Column(name = "direccion", nullable = false)
    private String Direccion;

    @Column(name = "ciudad", nullable = false)
    private String Ciudad;

    @Column(name = "departamento", nullable = false)
    private String Departamento;

    @OneToOne
    private Proveedor proveedor;

    public ContactoInfo(Long id, String telefono, String direccion, String ciudad, String departamento,
            Proveedor proveedor) {
        Id = id;
        Telefono = telefono;
        Direccion = direccion;
        Ciudad = ciudad;
        Departamento = departamento;
        this.proveedor = proveedor;
    }
    public ContactoInfo() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
