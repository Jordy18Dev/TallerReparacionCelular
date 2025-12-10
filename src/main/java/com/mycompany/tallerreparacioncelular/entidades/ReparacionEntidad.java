package com.mycompany.tallerreparacioncelular.entidades;

/**
 *
 * @author hamilton
 */
public class ReparacionEntidad {
    private String idReparacion;
    private String cedulaCliente; // Relación con Cliente (ID)
    private String nombreCliente; // Nombre del cliente (redundancia útil para listados)
    private String imeiEquipo;    // Relación con Equipo
    private String fechaIngreso;
    private String estado;        // Ej: Ingresado, En Revisión, Terminado, Entregado
    private String descripcionFalla;
    private double costoEstimado;

    public ReparacionEntidad(String idReparacion, String cedulaCliente, String nombreCliente, String imeiEquipo, String fechaIngreso, String estado, String descripcionFalla, double costoEstimado) {
        this.idReparacion = idReparacion;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.imeiEquipo = imeiEquipo;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.descripcionFalla = descripcionFalla;
        this.costoEstimado = costoEstimado;
    }

    public String getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(String idReparacion) {
        this.idReparacion = idReparacion;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getImeiEquipo() {
        return imeiEquipo;
    }

    public void setImeiEquipo(String imeiEquipo) {
        this.imeiEquipo = imeiEquipo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcionFalla() {
        return descripcionFalla;
    }

    public void setDescripcionFalla(String descripcionFalla) {
        this.descripcionFalla = descripcionFalla;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }
}
