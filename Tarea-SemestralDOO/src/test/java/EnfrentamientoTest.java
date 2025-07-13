import modelos.Enfrentamiento;
import modelos.Participante;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EnfrentamientoTest {


    Participante participante1 = new Participante("Colo-Colo");
    Participante participante2 = new Participante("Real Madrid");
    Enfrentamiento enfrentamiento = new Enfrentamiento(participante2,participante1,new Date("24/12/2025"));

    @Test
    void getGanador() {
        assertNull(enfrentamiento.getGanador());
    }

    @Test
    void setGanador() {
        enfrentamiento.setGanador(participante1);
        assertEquals(participante1,enfrentamiento.getGanador());
    }

    @Test
    void isEmpate() {
        assertFalse(enfrentamiento.isEmpate());
    }

    @Test
    void setEmpate() {
        enfrentamiento.setEmpate();
        assertTrue(enfrentamiento.isEmpate());
    }

    @Test
    void getFecha() {
        Date fecha = new Date("24/12/2025");
        assertEquals(fecha,enfrentamiento.getFecha());
    }

    @Test
    void testToString() {
        assertEquals("Partido: Real Madrid vs Colo-Colo",enfrentamiento.toString());
    }
}