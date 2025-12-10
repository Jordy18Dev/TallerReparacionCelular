package com.mycompany.tallerreparacioncelular.Controlador;

import com.mycompany.tallerreparacioncelular.entidades.ReparacionEntidad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hamilton
 */
public class ReparacionControlador {
    // Lista en memoria de las reparaciones
    private final List<ReparacionEntidad> reparaciones = new ArrayList<>();
    
    public ReparacionControlador() {
        // Datos de prueba actualizados con el nombre del cliente
        reparaciones.add(new ReparacionEntidad(
            "REP-001", 
            "0912345678", 
            "Jordy Malagon", 
            "12345678901234", 
            "09/12/2025", 
            "Ingresado", 
            "Pantalla rota", 
            45.00
        ));
    }

    // Listar todas las reparaciones
    public List<ReparacionEntidad> listar() {
        return Collections.unmodifiableList(reparaciones);
    }

    // Registrar una nueva reparación
    public void registrar(ReparacionEntidad reparacion) {
        if (reparacion == null) {
            throw new IllegalArgumentException("La información de reparación no es válida.");
        }
        // Validar que no exista el ID (opcional)
        for(ReparacionEntidad r : reparaciones){
            if(r.getIdReparacion().equals(reparacion.getIdReparacion())){
                throw new IllegalArgumentException("El ID de reparación ya existe.");
            }
        }
        reparaciones.add(reparacion);
    }
    
    // Actualizar estado o datos de una reparación
    public void actualizar(String id, String nuevoEstado, double nuevoCosto) {
        ReparacionEntidad rep = buscarPorId(id);
        if (rep != null) {
            rep.setEstado(nuevoEstado);
            rep.setCostoEstimado(nuevoCosto);
        } else {
            throw new IllegalArgumentException("Reparación no encontrada.");
        }
    }
    
    // Eliminar una reparación por su ID
    public void eliminar(String id) {
        ReparacionEntidad rep = buscarPorId(id);
        
        if (rep != null) {
            reparaciones.remove(rep);
        } else {
            throw new IllegalArgumentException("No se puede eliminar: Reparación no encontrada.");
        }
    }

    // Buscar por ID
    public ReparacionEntidad buscarPorId(String id) {
        for (ReparacionEntidad r : reparaciones) {
            if (r.getIdReparacion().equalsIgnoreCase(id)) {
                return r;
            }
        }
        return null; // No encontrado
    }
}
