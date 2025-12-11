/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.tallerreparacioncelular.Controlador;

import com.mycompany.tallerreparacioncelular.entidades.Tecnico;
import java.util.ArrayList;
import java.util.List;

public class TecnicoControlador {

    private final List<Tecnico> listaTecnicos;
    private int contadorId;

    public TecnicoControlador() {
        this.listaTecnicos = new ArrayList<>();
        this.contadorId = 1;
    }

    // Genera IDs tipo T001, T002, T003...
    private String generarId() {
        String id = String.format("T%03d", contadorId);
        contadorId++;
        return id;
    }

    // Registrar técnico
    public String registrarTecnico(Tecnico tecnico) {
        if (tecnico == null) {
            return "ERROR: TÉCNICO NO VÁLIDO.";
        }

        String mensajeValidacion = validarTecnicoParaRegistro(tecnico);
        if (!mensajeValidacion.equals("OK")) {
            return mensajeValidacion;
        }

        // Verificar duplicados por cédula o correo
        if (existeCedula(tecnico.getCedula())) {
            return "ERROR: LA CÉDULA YA ESTÁ REGISTRADA.";
        }
        if (existeCorreo(tecnico.getCorreo())) {
            return "ERROR: EL CORREO YA ESTÁ REGISTRADO.";
        }

        tecnico.setId(generarId());
        listaTecnicos.add(tecnico);
        return "Técnico registrado correctamente.";
    }

    // Consultar técnico por cédula (puedes ampliar luego por nombre/correo)
    public Tecnico consultarPorCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return null;
        }
        for (Tecnico t : listaTecnicos) {
            if (t.getCedula() != null && t.getCedula().equals(cedula)) {
                return t;
            }
        }
        return null;
    }

    // Actualizar técnico (se busca por cédula)
    public String actualizarTecnico(Tecnico tecnicoActualizado) {
        if (tecnicoActualizado == null) {
            return "ERROR: TÉCNICO NO VÁLIDO.";
        }

        String cedula = tecnicoActualizado.getCedula();
        if (cedula == null || cedula.trim().isEmpty()) {
            return "ERROR: CÉDULA OBLIGATORIA PARA ACTUALIZAR.";
        }

        Tecnico existente = consultarPorCedula(cedula);
        if (existente == null) {
            return "ERROR: NO SE ENCONTRÓ TÉCNICO CON ESA CÉDULA.";
        }

        String mensajeValidacion = validarTecnicoParaActualizacion(tecnicoActualizado);
        if (!mensajeValidacion.equals("OK")) {
            return mensajeValidacion;
        }

        // Validar correo duplicado (si cambió)
        if (!tecnicoActualizado.getCorreo().equals(existente.getCorreo())
                && existeCorreo(tecnicoActualizado.getCorreo())) {
            return "ERROR: EL CORREO YA ESTÁ REGISTRADO EN OTRO TÉCNICO.";
        }

        // No se cambia id ni cédula
        existente.setNombres(tecnicoActualizado.getNombres());
        existente.setApellidos(tecnicoActualizado.getApellidos());
        existente.setCorreo(tecnicoActualizado.getCorreo());
        existente.setHabilidades(tecnicoActualizado.getHabilidades());
        existente.setDisponibilidad(tecnicoActualizado.getDisponibilidad());
        existente.setCelular(tecnicoActualizado.getCelular());
        existente.setHorasTrabajadas(tecnicoActualizado.getHorasTrabajadas());

        return "Técnico actualizado correctamente.";
    }

    // Eliminar técnico (por cédula) – aquí lo marcamos como inactivo con disponibilidad = "INACTIVO"
    public String eliminarTecnicoPorCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return "ERROR: CÉDULA OBLIGATORIA PARA ELIMINAR.";
        }

        Tecnico existente = consultarPorCedula(cedula);
        if (existente == null) {
            return "ERROR: NO SE ENCONTRÓ TÉCNICO CON ESA CÉDULA.";
        }

        // En lugar de borrar del ArrayList, lo marcamos inactivo
        existente.setDisponibilidad("INACTIVO");
        return "Técnico dado de baja correctamente.";
    }

    // Listar todos los técnicos
    public List<Tecnico> listarTecnicos() {
        return new ArrayList<>(listaTecnicos);
    }

    // ====== MÉTODOS DE APOYO / VALIDACIÓN ======

    private boolean existeCedula(String cedula) {
        if (cedula == null) {
            return false;
        }
        for (Tecnico t : listaTecnicos) {
            if (cedula.equals(t.getCedula())) {
                return true;
            }
        }
        return false;
    }

    private boolean existeCorreo(String correo) {
        if (correo == null) {
            return false;
        }
        for (Tecnico t : listaTecnicos) {
            if (correo.equalsIgnoreCase(t.getCorreo())) {
                return true;
            }
        }
        return false;
    }

    private String validarTecnicoParaRegistro(Tecnico t) {
        if (esVacio(t.getNombres()) || esVacio(t.getApellidos())
                || esVacio(t.getCedula()) || esVacio(t.getCorreo())) {
            return "ERROR: COMPLETE LOS CAMPOS OBLIGATORIOS.";
        }

        if (!esCedulaValida(t.getCedula())) {
            return "ERROR: LA CÉDULA DEBE TENER 10 DÍGITOS NUMÉRICOS.";
        }

        if (!esCorreoValido(t.getCorreo())) {
            return "ERROR: CORREO CON FORMATO INVÁLIDO.";
        }

        if (!esCelularValido(t.getCelular())) {
            return "ERROR: EL CELULAR DEBE TENER 10 DÍGITOS NUMÉRICOS.";
        }

        return "OK";
    }

    private String validarTecnicoParaActualizacion(Tecnico t) {
        // Puedes permitir menos cosas obligatorias que en registro si quieres,
        // pero por ahora mantenemos igual.
        return validarTecnicoParaRegistro(t);
    }

    private boolean esVacio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    private boolean esCedulaValida(String cedula) {
        if (cedula == null) {
            return false;
        }
        if (cedula.length() != 10) {
            return false;
        }
        for (int i = 0; i < cedula.length(); i++) {
            if (!Character.isDigit(cedula.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean esCelularValido(String celular) {
        if (celular == null) {
            return false;
        }
        if (celular.length() != 10) {
            return false;
        }
        for (int i = 0; i < celular.length(); i++) {
            if (!Character.isDigit(celular.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean esCorreoValido(String correo) {
        if (correo == null) {
            return false;
        }
        correo = correo.trim();
        if (correo.length() < 5 || !correo.contains("@") || !correo.contains(".")) {
            return false;
        }
        return true;
    }
}