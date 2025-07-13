import modelos.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class CalendarioTest {
    private Calendario calendario;
    static private Participantes participantes = new Participantes();

    @BeforeAll
    static void setUp(){
        participantes.addParticipante(new Participante("equipo 1"));
        participantes.addParticipante(new Participante("equipo 2"));
        participantes.addParticipante(new Participante("equipo 3"));
        participantes.addParticipante(new Participante("equipo 4"));
    }

    @Test
    void testToString() {
        calendario = new Calendario(TipoTorneo.EliminacionDirecta);
        calendario.crearCalendario(TipoTorneo.EliminacionDirecta,1,CantidadParticipantes.Cuatro, participantes);
        assertEquals(105,calendario.toString().length());
    }

    @Test
    void getJornadas(){
        calendario = new Calendario(TipoTorneo.Liga);
        assertNotNull(calendario.getJornadas());
    }

    @Test
    @DisplayName("Creacion de calendario tipo liga con 1 enfrentamiento.")
    void crearCalendarioLiga1() {
        calendario = new Calendario(TipoTorneo.Liga);
        calendario.crearCalendario(TipoTorneo.Liga,1, CantidadParticipantes.Cuatro,participantes);
        assertEquals(calendario.getJornadas().size(),3);
    }

    @Test
    @DisplayName("Creacion de calendario tipo liga con 2 enfrentamiento.")
    void crearCalendarioLiga2() {
        calendario = new Calendario(TipoTorneo.Liga);
        calendario.crearCalendario(TipoTorneo.Liga,2, CantidadParticipantes.Cuatro,participantes);
        assertEquals(calendario.getJornadas().size(),6);
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 1 enfrentamiento.")
    void crearCalendarioElimDirect1(){
        calendario = new Calendario(TipoTorneo.EliminacionDirecta);
        calendario.crearCalendario(TipoTorneo.EliminacionDirecta,1, CantidadParticipantes.Cuatro,participantes);
        assertEquals(2,calendario.getJornadas().size());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 2 enfrentamiento.")
    void crearCalendarioElimDirect2(){
        calendario = new Calendario(TipoTorneo.EliminacionDirecta);
        calendario.crearCalendario(TipoTorneo.EliminacionDirecta,2, CantidadParticipantes.Cuatro,participantes);
        assertEquals(4,calendario.getJornadas().size());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 2 enfrentamiento y 8 equipos.")
    void crearCalendario8(){
        calendario = new Calendario(TipoTorneo.EliminacionDirecta);
        calendario.crearCalendario(TipoTorneo.EliminacionDirecta,2, CantidadParticipantes.Ocho,participantes);
        assertEquals(6,calendario.getJornadas().size());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 2 enfrentamiento y 16 equipos.")
    void crearCalendario16() {
        calendario = new Calendario(TipoTorneo.EliminacionDirecta);
        calendario.crearCalendario(TipoTorneo.EliminacionDirecta, 2, CantidadParticipantes.Dieciseis, participantes);
        assertEquals(8, calendario.getJornadas().size());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 2 enfrentamiento y 32 equipos.")
    void crearCalendario32() {
        calendario = new Calendario(TipoTorneo.EliminacionDirecta);
        calendario.crearCalendario(TipoTorneo.EliminacionDirecta, 2, CantidadParticipantes.TreintayDos, participantes);
        assertEquals(10, calendario.getJornadas().size());
    }

    @Test
    void getTipoDeCalendario(){
        calendario =new Calendario(TipoTorneo.Liga);
        assertNotNull(calendario.getTipoDeCalendario());
    }

    @Test
    void setTipoDeCalendario() {

    }
}