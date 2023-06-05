package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Fecha_Emision,Fecha_Vencimiento,Moneda,Tipo_Cambio,Serie,Dni,Razon_Social,Direccion,Departamento,Distrito;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFecha_Emision() {
        return Fecha_Emision;
    }

    public void setFecha_Emision(String fecha_Emision) {
        Fecha_Emision = fecha_Emision;
    }

    public String getFecha_Vencimiento() {
        return Fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(String fecha_Vencimiento) {
        Fecha_Vencimiento = fecha_Vencimiento;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String moneda) {
        Moneda = moneda;
    }

    public String getTipo_Cambio() {
        return Tipo_Cambio;
    }

    public void setTipo_Cambio(String tipo_Cambio) {
        Tipo_Cambio = tipo_Cambio;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String serie) {
        Serie = serie;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String razon_Social) {
        Razon_Social = razon_Social;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    
}
