package modelos;

import org.junit.jupiter.api.Test;
import vistas.PanelPrincipal;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EnfrentamientoTest {
    Participante participante1 = new Participante("Colo-Colo","CC@Gmail.com");
    Participante participante2 = new Participante("Real Madrid","RealMadridCF@gmail.com");
    Enfrentamiento enfrentamiento = new Enfrentamiento(participante2,participante1,new Date("24/12/2025"));

    @Test
    void getGanador() {
        PanelPrincipal.torneo = new Torneo("prueba", TipoTorneo.Liga);
        assertNull(enfrentamiento.getGanador());
    }

    @Test
    void setGanador() {
        PanelPrincipal.torneo = new Torneo("prueba", TipoTorneo.Liga);
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
    void getPerdedor(){
        PanelPrincipal.torneo = new Torneo("prueba", TipoTorneo.Liga);
        enfrentamiento.setGanador(participante1);
        assertEquals(participante2,enfrentamiento.getPerdedor());
    }

    @Test
    void getLocal(){
        assertEquals(participante2,enfrentamiento.getLocal());
    }

    @Test
    void getVisita(){
        assertEquals(participante1,enfrentamiento.getVisita());
    }

    @Test
    void getStringLocal(){
        assertEquals("Real Madrid",enfrentamiento.getStringLocal());
    }

    @Test
    void getStringVisita(){
        assertEquals(participante1,enfrentamiento.getVisita());
    }

    @Test
    void getFecha() {
        PanelPrincipal.torneo = new Torneo("prueba", TipoTorneo.Liga);
        assertEquals("12/12",enfrentamiento.getFecha());
    }

    @Test
    void testToString() {
        assertEquals("Partido: Real Madrid vs Colo-Colo",enfrentamiento.toString());
    }
}