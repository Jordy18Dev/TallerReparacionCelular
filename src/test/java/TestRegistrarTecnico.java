

import com.mycompany.tallerreparacioncelular.Controlador.TecnicoControlador;
import com.mycompany.tallerreparacioncelular.entidades.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRegistrarTecnico {

    @Test
    public void testRegistrarTecnico_Correcto() {
        TecnicoControlador controlador = new TecnicoControlador();
        Tecnico t = new Tecnico("Juan", "Perez", "0123456789", "juan@test.com",
                "Reparación", "DISPONIBLE", "0987654321", 40);

        String resultado = controlador.registrarTecnico(t);

        assertEquals("Técnico registrado correctamente.", resultado);
    }

    @Test
    public void testRegistrarTecnico_ErrorCedulaDuplicada() {
        TecnicoControlador controlador = new TecnicoControlador();

        Tecnico t1 = new Tecnico("Juan", "Perez", "0123456789", "juan@test.com",
                "Reparación", "DISPONIBLE", "0987654321", 40);
        Tecnico t2 = new Tecnico("Pedro", "Lopez", "0123456789", "pedro@test.com",
                "Software", "DISPONIBLE", "0912345678", 30);

        controlador.registrarTecnico(t1);
        String resultado = controlador.registrarTecnico(t2);

        assertEquals("ERROR: LA CÉDULA YA ESTÁ REGISTRADA.", resultado);
    }
}