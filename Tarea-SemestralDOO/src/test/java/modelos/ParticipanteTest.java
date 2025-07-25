package modelos;

import org.junit.jupiter.api.Test;
import vistas.PanelPrincipal;

import static org.junit.Assert.assertEquals;

class ParticipanteTest {
    Participante participante = new Participante("fff", "fff@yahoo.com");

    @Test
    void registrarResultado() {
        PanelPrincipal.torneo = new Torneo("t1", TipoTorneo.Liga);
        participante.registrarResultado(Resultados.Victoria);
        assertEquals(1, participante.getWins());
    }

    @Test
    void getNombre() {
        assertEquals("fff", participante.getNombre());
    }

    @Test
    void getContacto() {
        assertEquals("fff@yahoo.com", participante.getContacto());
    }

    @Test
    void getPartidosJugados(){
        assertEquals(0,participante.getPartidosJugados());
    }

    @Test
    void getWins(){
        assertEquals(0,participante.getWins());
    }

    @Test
    void getLosses(){
        assertEquals(0,participante.getLosses());
    }

    @Test
    void getDraws(){
        assertEquals(0,participante.getDraws());
    }

    @Test
    void getPuntos(){
        assertEquals(0,participante.getPuntos());
    }

    @Test
    void setNombre(){
        participante.setNombre("aaa");
        assertEquals("aaa",participante.getNombre());
    }

    @Test
    void tostring(){
        assertEquals("fff Contacto: fff@yahoo.com\n",participante.toString());
    }
}