/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerreparacioncelular.entidades;

import java.util.Objects;
/**
 *
 * @author lady
 */
public class EquipoEntidad {

    // ID interno para uso del taller (lo escribes en el formulario)
    private final String idInterno;

    private String marca;
    private String modelo;
    private String imei;
    private String fallaReportada;
    private String accesoriosEntregados;

    public EquipoEntidad(String idInterno,
                         String marca,
                         String modelo,
                         String imei,
                         String fallaReportada,
                         String accesoriosEntregados) {
        this.idInterno = idInterno;
        this.marca = marca;
        this.modelo = modelo;
        this.imei = imei;
        this.fallaReportada = fallaReportada;
        this.accesoriosEntregados = accesoriosEntregados;
    }

    public String getIdInterno() {
        return idInterno;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getFallaReportada() {
        return fallaReportada;
    }

    public void setFallaReportada(String fallaReportada) {
        this.fallaReportada = fallaReportada;
    }

    public String getAccesoriosEntregados() {
        return accesoriosEntregados;
    }

    public void setAccesoriosEntregados(String accesoriosEntregados) {
        this.accesoriosEntregados = accesoriosEntregados;
    }

    // Para manejar colecciones sin duplicar por ID interno
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipoEntidad)) return false;
        EquipoEntidad that = (EquipoEntidad) o;
        return Objects.equals(idInterno, that.idInterno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInterno);
    }
}
