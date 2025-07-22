import modelos.*;
import org.junit.jupiter.api.Test;
import vistas.PanelPrincipal;

import static org.junit.Assert.assertEquals;

class ParticipanteTest {
    Participante participante = new Participante("fff","fff@yahoo.com");

    @Test
    void getWins() {
        assertEquals(0,participante.getWins());
    }

    @Test
    void getLosses() {
        assertEquals(0,participante.getLosses());
    }

    @Test
    void getDraws() {
        assertEquals(0,participante.getDraws());
    }

    @Test
    void registrarResultado() {
        PanelPrincipal.torneo = new Torneo("t1", TipoTorneo.Liga);
        participante.registrarResultado(Resultados.Victoria);
        assertEquals(1,participante.getWins());
    }

    @Test
    void getNombre() {
        assertEquals("fff",participante.getNombre());
    }

    @Test
    void getContacto() {
        assertEquals("fff@yahoo.com",participante.getContacto());
    }

    @Test
    void getPartidosJugados() {
        assertEquals(0,participante.getPartidosJugados());
    }

    @Test
    void getPuntos() {
        participante.setPuntos(13);
        assertEquals(13,participante.getPuntos());
    }

    @Test
    void setPartidosJugados() {
        participante.setPartidosJugados(0);
        assertEquals(0,participante.getPartidosJugados());
    }

    @Test
    void setWins() {
        participante.setWins(3);
        assertEquals(3,participante.getWins());
    }

    @Test
    void setNombre() {
        participante.setNombre("aaa");
        assertEquals("aaa",participante.getNombre());
    }

    @Test
    void setDraws() {
        participante.setDraws(43);
        assertEquals(43,participante.getDraws());
    }

    @Test
    void setLosses() {
        participante.setLosses(11);
        assertEquals(11,participante.getLosses());
    }

    @Test
    void setPuntos() {
        participante.setPuntos(44);
        assertEquals(44,participante.getPuntos());
    }

    @Test
    void setContacto() {
        participante.setContacto("aaa@proton.me");
        assertEquals("aaa@proton.me",participante.getContacto());
    }
}