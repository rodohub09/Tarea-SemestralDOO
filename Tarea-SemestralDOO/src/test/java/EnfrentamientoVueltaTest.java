import modelos.Enfrentamiento;
import modelos.Participante;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EnfrentamientoVueltaTest {

    Participante participante1 = new Participante("Colo-Colo","CC@Gmail.com");
    Participante participante2 = new Participante("Real Madrid","RealMadridCF@gmail.com");
    Enfrentamiento enfrentamiento = new Enfrentamiento(participante2,participante1,new Date("24/12/2025"));
    EnfrentamientoVuelta enfrentamientoVuelta = new EnfrentamientoVuelta(participante1,participante2,new Date("31/12/2025"),enfrentamiento);

    @Test
    void getGanador() {
        assertNull(enfrentamientoVuelta.getGanador());
    }

    @Test
    void setGanador() {
        enfrentamientoVuelta.setGanador(participante1);
        assertEquals("Colo-Colo",enfrentamientoVuelta.getGanador().getNombre());
    }

    @Test
    void getGanadorDeEstePartido() {
        assertNull(enfrentamientoVuelta.getGanadorDeEstePartido());
    }

    @Test
    void setGanadorDeEstePartido() {
        enfrentamientoVuelta.setGanadorDeEstePartido(participante1);
        assertEquals("Colo-Colo",enfrentamientoVuelta.getGanadorDeEstePartido().getNombre());
    }
}