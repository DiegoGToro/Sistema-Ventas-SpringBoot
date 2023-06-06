package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Nombre, Apellido;
    private String Email, Password;
    private byte RolUsuario;
    private Long Telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;

    public Usuario() {
        RolUsuario = 1;
    }

    public Usuario(Long id, String nombre, String apellido, String email, String password, Long telefono) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Password = password;
        RolUsuario = 1;
        Telefono = telefono;
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

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
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

    public Long getTelefono() {
        return Telefono;
    }

    public void setTelefono(Long telefono) {
        Telefono = telefono;
    }

    public byte getRolUsuario() {
        return RolUsuario;
    }

    public void setRolUsuario(byte rolUsuario) {
        RolUsuario = rolUsuario;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public String toString() {
        return "Usuario [Id=" + Id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Email=" + Email
                + ", Password=" + Password + ", RolUsuario=" + RolUsuario + ", Telefono=" + Telefono + ", ordenes="
                + ordenes + "]";
    }
}
