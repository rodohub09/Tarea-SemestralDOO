package modelos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarioTest {
    private Calendario calendario;
    private static Participantes participantes;

    @BeforeAll
    static void setUp() {
        participantes = new Participantes();
        participantes.addParticipante(new Participante("equipo 1", "equipo1@proton.me"));
        participantes.addParticipante(new Participante("equipo 2", "equipo2@proton.me"));
        participantes.addParticipante(new Participante("equipo 3", "equipo3@proton.me"));
        participantes.addParticipante(new Participante("equipo 4", "equipo4@proton.me"));
        participantes.setAgrupacionParticipantes(TipoTorneo.Liga);
    }

    @Test
    void testToString() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Liga, 1, CantidadParticipantes.Cuatro, participantes);
        assertEquals("Jornada 1:\n" +
                "Partido: equipo 1 vs equipo 4\n" +
                "Partido: equipo 2 vs equipo 3\n" +
                "\n" +
                "Jornada 2:\n" +
                "Partido: equipo 2 vs equipo 4\n" +
                "Partido: equipo 3 vs equipo 1\n" +
                "\n" +
                "Jornada 3:\n" +
                "Partido: equipo 3 vs equipo 4\n" +
                "Partido: equipo 1 vs equipo 2\n" +
                "\n", calendario.toString());
    }

    @Test
    void getCantJornada() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Liga, 2, CantidadParticipantes.Cuatro, participantes);
        assertEquals(6, calendario.getCantJornadas());
    }

    @Test
    void getJornada() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Eliminacion_Directa, 1, CantidadParticipantes.Cuatro, participantes);
        assertEquals("Partido: equipo 1 vs equipo 4\n" +
                "Partido: equipo 2 vs equipo 3\n", calendario.getJornada(0).toString());
    }

    @Test
    @DisplayName("Creacion de calendario tipo liga con 1 enfrentamiento.")
    void crearCalendarioLiga1() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Liga, 1, CantidadParticipantes.Cuatro, participantes);
        assertEquals(calendario.getCantJornadas(), 3);
    }

    @Test
    void getysetTipoDeCalendario() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Liga, 1, CantidadParticipantes.Cuatro, participantes);
        CalendarioXPuntos prueba = new CalendarioXPuntos();
        assertTrue(prueba.getClass().equals(calendario.getTipoDeCalendario().getClass()));
    }



}