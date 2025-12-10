/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerreparacioncelular.Controlador;

import com.mycompany.tallerreparacioncelular.entidades.EquipoEntidad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author lady
 */
public class EquipoControlador {

    private final List<EquipoEntidad> equipos = new ArrayList<>();

    public EquipoControlador() {
        precargarDatosEjemplo();
    }

    // ---------- CONSULTAS ----------

    public List<EquipoEntidad> listarTodos() {
        return Collections.unmodifiableList(equipos);
    }

    /** RF-6: consultar únicamente por IMEI */
    public EquipoEntidad buscarPorImei(String imei) {
        if (imei == null) return null;
        String buscado = imei.trim();
        for (EquipoEntidad e : equipos) {
            if (e.getImei().equals(buscado)) {
                return e;
            }
        }
        return null;
    }

    // ---------- REGISTRO (RF-5) ----------

    public void registrar(EquipoEntidad nuevo) {
        validarDatosObligatorios(nuevo);

        // IMEI único (CU07 – curso alterno 2) :contentReference[oaicite:4]{index=4}
        if (buscarPorImei(nuevo.getImei()) != null) {
            throw new IllegalArgumentException("ERROR: EL IMEI YA EXISTE EN OTRO REGISTRO.");
        }

        equipos.add(nuevo);
    }

    // ---------- ACTUALIZAR (RF-7) ----------

    /**
     * Actualiza usando el IMEI original.
     * Permite cambiar marca, modelo, imei, falla, accesorios.
     */
    public void actualizar(String imeiOriginal, EquipoEntidad datosNuevos) {
        if (imeiOriginal == null) {
            throw new IllegalArgumentException("ERROR: IMEI ORIGINAL INVÁLIDO.");
        }

        EquipoEntidad existente = buscarPorImei(imeiOriginal.trim());
        if (existente == null) {
            throw new IllegalArgumentException("ERROR: EL EQUIPO NO EXISTE.");
        }

        validarDatosObligatorios(datosNuevos);

        // Si cambias el IMEI, verificar que no esté repetido
        if (!imeiOriginal.trim().equals(datosNuevos.getImei())) {
            if (buscarPorImei(datosNuevos.getImei()) != null) {
                throw new IllegalArgumentException("ERROR: EL IMEI YA EXISTE EN OTRO REGISTRO.");
            }
        }

        existente.setMarca(datosNuevos.getMarca());
        existente.setModelo(datosNuevos.getModelo());
        existente.setImei(datosNuevos.getImei());
        existente.setFallaReportada(datosNuevos.getFallaReportada());
        existente.setAccesoriosEntregados(datosNuevos.getAccesoriosEntregados());
    }

    // ---------- ELIMINAR (RF-8) ----------

    public void eliminarPorImei(String imei) {
        if (imei == null) {
            throw new IllegalArgumentException("ERROR: IMEI INVÁLIDO.");
        }

        EquipoEntidad existente = buscarPorImei(imei.trim());
        if (existente == null) {
            throw new IllegalArgumentException("ERROR: EL EQUIPO NO EXISTE.");
        }

        equipos.remove(existente);
    }

    // ---------- VALIDACIONES SEGÚN RF-5 ----------

    private void validarDatosObligatorios(EquipoEntidad e) {
        if (e == null) {
            throw new IllegalArgumentException("ERROR: FALTAN DATOS OBLIGATORIOS.");
        }

        String marca = safe(e.getMarca());
        String modelo = safe(e.getModelo());
        String imei = safe(e.getImei());
        String falla = safe(e.getFallaReportada());
        String accesorios = safe(e.getAccesoriosEntregados());

        // Campos vacíos
        if (marca.isEmpty() || modelo.isEmpty() || imei.isEmpty() || falla.isEmpty()) {
            throw new IllegalArgumentException("ERROR: FALTAN DATOS OBLIGATORIOS.");
        }

        // Marca: 3–30 caracteres
        if (marca.length() < 3 || marca.length() > 30) {
            throw new IllegalArgumentException("ERROR: MARCA DEBE TENER ENTRE 3 Y 30 CARACTERES.");
        }

        // Modelo: 3–30 caracteres
        if (modelo.length() < 3 || modelo.length() > 30) {
            throw new IllegalArgumentException("ERROR: MODELO DEBE TENER ENTRE 3 Y 30 CARACTERES.");
        }

        // IMEI: solo números, 14–16 dígitos :contentReference[oaicite:5]{index=5}
        if (!imei.matches("\\d{14,16}")) {
            throw new IllegalArgumentException("ERROR: IMEI INVÁLIDO.");
        }

        // Falla: 5–200 caracteres
        if (falla.length() < 5 || falla.length() > 200) {
            throw new IllegalArgumentException("ERROR: LA FALLA REPORTADA DEBE TENER ENTRE 5 Y 200 CARACTERES.");
        }

        // Accesorios: máximo 100 caracteres
        if (accesorios.length() > 100) {
            throw new IllegalArgumentException("ERROR: ACCESORIOS ENTREGADOS NO PUEDE SUPERAR 100 CARACTERES.");
        }
    }

    private String safe(String s) {
        return s == null ? "" : s.trim();
    }

    // ---------- Datos de ejemplo para que la tabla no esté vacía ----------

    private void precargarDatosEjemplo() {
        equipos.add(new EquipoEntidad(
                "1",
                "Xiaomi",
                "A24",
                "12345678901234",
                "no enciende",
                "cargador"
        ));
        equipos.add(new EquipoEntidad(
                "2",
                "Huawei",
                "P30",
                "12345678901235",
                "no carga",
                "cargador, funda"
        ));
    }
}
