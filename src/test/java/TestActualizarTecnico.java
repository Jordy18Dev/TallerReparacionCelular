/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.tallerreparacioncelular.Controlador.TecnicoControlador;
import com.mycompany.tallerreparacioncelular.entidades.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestActualizarTecnico {

    @Test
    public void testActualizarTecnico_Correcto() {
        TecnicoControlador controlador = new TecnicoControlador();

        Tecnico original = new Tecnico("Juan", "Perez", "0123456789", "juan@test.com",
                "Reparación", "DISPONIBLE", "0987654321", 40);
        controlador.registrarTecnico(original);

        Tecnico actualizado = new Tecnico("Juan Carlos", "Perez", "0123456789", "juan@test.com",
                "Software", "DISPONIBLE", "0987654321", 50);

        String resultado = controlador.actualizarTecnico(actualizado);

        assertEquals("Técnico actualizado correctamente.", resultado);
    }

    @Test
    public void testActualizarTecnico_ErrorCedulaNoExiste() {
        TecnicoControlador controlador = new TecnicoControlador();

        Tecnico t = new Tecnico("Luis", "Mora", "0000000000", "luis@test.com",
                "Reparación", "DISPONIBLE", "0999999999", 20);

        String resultado = controlador.actualizarTecnico(t);

        assertEquals("ERROR: NO SE ENCONTRÓ TÉCNICO CON ESA CÉDULA.", resultado);
    }
}