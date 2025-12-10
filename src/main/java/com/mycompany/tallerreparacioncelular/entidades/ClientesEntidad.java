/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerreparacioncelular.entidades;

import java.util.Objects;

/**
 *
 * @author jorda
 */
public class ClientesEntidad {
    
private final String cedula;        // ID único (no debería cambiar)
    private String nombresCompletos;
    private String direccion;
    private String celular;
    private String correo;

    public ClientesEntidad(String cedula, String nombresCompletos, String direccion, String celular, String correo) {
        this.cedula = cedula;
        this.nombresCompletos = nombresCompletos;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public void setNombresCompletos(String nombresCompletos) {
        this.nombresCompletos = nombresCompletos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Para poder buscar/actualizar/eliminar por cédula fácilmente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientesEntidad)) return false;
        ClientesEntidad cliente = (ClientesEntidad) o;
        return Objects.equals(cedula, cliente.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
    
}
