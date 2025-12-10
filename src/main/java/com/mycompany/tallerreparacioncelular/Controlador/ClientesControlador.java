package com.mycompany.tallerreparacioncelular.Controlador;

import com.mycompany.tallerreparacioncelular.entidades.ClientesEntidad;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author jorda
 */
public class ClientesControlador {
    
    private final List<ClientesEntidad> clientes = new ArrayList<>();

    public ClientesControlador() {
        precargarDatos();
    }

    // --- Lecturas ---
    public List<ClientesEntidad> listar() {
        return Collections.unmodifiableList(clientes);
    }

    public ClientesEntidad buscarPorCedula(String cedula) {
        if (isBlank(cedula)) return null;
        String key = cedula.trim();
        for (ClientesEntidad c : clientes) {
            if (c.getCedula().equals(key)) return c;
        }
        return null;
    }

    /**
     * Búsqueda NO estricta:
     * - Ignora mayúsculas/minúsculas
     * - Ignora tildes (á -> a)
     * - Si escribes solo nombre o solo apellido, igual encuentra (contains)
     * - Si escribes 2+ palabras, exige que todas aparezcan en el nombre (más preciso)
     */
    public List<ClientesEntidad> buscarPorNombre(String texto) {
        if (isBlank(texto)) {
            // Si no hay texto, devuelve todos (útil para "limpiar búsqueda")
            return listar();
        }

        String q = normalize(texto);
        String[] tokens = q.split("\\s+");

        List<ClientesEntidad> result = new ArrayList<>();
        for (ClientesEntidad c : clientes) {
            String full = normalize(c.getNombresCompletos());

            boolean match;
            if (tokens.length <= 1) {
                match = full.contains(q); // "jordy" encuentra "jordy malagon"
            } else {
                match = true; // todas las palabras deben estar
                for (String t : tokens) {
                    if (!full.contains(t)) { match = false; break; }
                }
            }

            if (match) result.add(c);
        }
        return result;
    }

    // --- Escrituras (CRUD) ---
    public void registrar(ClientesEntidad nuevo) {
        validarCamposObligatorios(nuevo);

        if (buscarPorCedula(nuevo.getCedula()) != null) {
            throw new IllegalArgumentException("Ya existe un cliente con esa cédula.");
        }
        clientes.add(nuevo);
    }

    public void actualizar(String cedula, ClientesEntidad nuevosDatos) {
        validarCamposObligatorios(nuevosDatos);

        ClientesEntidad existente = buscarPorCedula(cedula);
        if (existente == null) {
            throw new IllegalArgumentException("No existe un cliente con esa cédula.");
        }

        // cedula NO cambia
        existente.setNombresCompletos(nuevosDatos.getNombresCompletos());
        existente.setDireccion(nuevosDatos.getDireccion());
        existente.setCelular(nuevosDatos.getCelular());
        existente.setCorreo(nuevosDatos.getCorreo());
    }

    public void eliminar(String cedula) {
        ClientesEntidad existente = buscarPorCedula(cedula);
        if (existente == null) {
            throw new IllegalArgumentException("No existe un cliente con esa cédula.");
        }
        clientes.remove(existente);
    }

    // --- Helpers ---
    private void precargarDatos() {
        clientes.add(new ClientesEntidad("0912345678", "Jordy Malagon", "Guayaquil", "0999999999", "jordy@mail.com"));
        clientes.add(new ClientesEntidad("0923456789", "Ana Ruiz", "Durán", "0988888888", "ana.ruiz@mail.com"));
        clientes.add(new ClientesEntidad("0934567890", "Carlos Mendoza", "Samborondón", "0977777777", "c.mendoza@mail.com"));
    }

    private void validarCamposObligatorios(ClientesEntidad c) {
        if (c == null) throw new IllegalArgumentException("Cliente inválido.");
        if (isBlank(c.getCedula())) throw new IllegalArgumentException("La cédula es obligatoria.");
        if (isBlank(c.getNombresCompletos())) throw new IllegalArgumentException("Los nombres son obligatorios.");
        if (isBlank(c.getDireccion())) throw new IllegalArgumentException("La dirección es obligatoria.");
        if (isBlank(c.getCelular())) throw new IllegalArgumentException("El celular es obligatorio.");
        if (isBlank(c.getCorreo())) throw new IllegalArgumentException("El correo es obligatorio.");
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private String normalize(String s) {
        if (s == null) return "";
        String t = s.trim().toLowerCase();
        // quita tildes/acentos
        t = Normalizer.normalize(t, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return t;
    }
    
    
    
}
