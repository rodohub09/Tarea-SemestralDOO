import modelos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarioTest {
    private Calendario calendario;
    static private Participantes participantes;

    @BeforeEach
    void setUp() {
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
    @DisplayName("Creacion de calendario tipo liga con 2 enfrentamiento.")
    void crearCalendarioLiga2() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Liga, 2, CantidadParticipantes.Cuatro, participantes);
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
                "\n" +
                "Jornada 4:\n" +
                "Partido: equipo 4 vs equipo 1\n" +
                "Partido: equipo 3 vs equipo 2\n" +
                "\n" +
                "Jornada 5:\n" +
                "Partido: equipo 4 vs equipo 2\n" +
                "Partido: equipo 1 vs equipo 3\n" +
                "\n" +
                "Jornada 6:\n" +
                "Partido: equipo 4 vs equipo 3\n" +
                "Partido: equipo 2 vs equipo 1\n\n", calendario.toString());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 1 enfrentamiento.")
    void crearCalendarioElimDirect1() {
        calendario = new Calendario();
        participantes.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario.setTipoDeCalendario(TipoTorneo.Eliminacion_Directa, 1, CantidadParticipantes.Cuatro, participantes);
        assertEquals(2, calendario.toString());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 2 enfrentamiento.")
    void crearCalendarioElimDirect2() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Eliminacion_Directa, 2, CantidadParticipantes.Cuatro, participantes);
        calendario.getJornada(0).getEnfrentamientos().get(0).setGanador(calendario.getJornada(0).getEnfrentamientos().get(0).local);
        calendario.getJornada(0).getEnfrentamientos().get(1).setGanador(calendario.getJornada(0).getEnfrentamientos().get(1).local);

        assertEquals(4, calendario.toString());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 2 enfrentamiento y 8 equipos.")
    void crearCalendario8() {
        participantes.addParticipante(new Participante("equipo 5", "equipo5@proton.me"));
        participantes.addParticipante(new Participante("equipo 6", "equipo6@proton.me"));
        participantes.addParticipante(new Participante("equipo 7", "equipo7@proton.me"));
        participantes.addParticipante(new Participante("equipo 8", "equipo8@proton.me"));
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Liga, 2, CantidadParticipantes.Ocho, participantes);
        assertEquals(14, calendario.getCantJornadas());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 2 enfrentamiento y 16 equipos.")
    void crearCalendario16() {
        participantes.addParticipante(new Participante("equipo 5", "equipo5@proton.me"));
        participantes.addParticipante(new Participante("equipo 6", "equipo6@proton.me"));
        participantes.addParticipante(new Participante("equipo 7", "equipo7@proton.me"));
        participantes.addParticipante(new Participante("equipo 8", "equipo8@proton.me"));
        participantes.addParticipante(new Participante("equipo 9", "equipo5@proton.me"));
        participantes.addParticipante(new Participante("equipo 10", "equipo6@proton.me"));
        participantes.addParticipante(new Participante("equipo 11", "equipo7@proton.me"));
        participantes.addParticipante(new Participante("equipo 12", "equipo8@proton.me"));
        participantes.addParticipante(new Participante("equipo 13", "equipo5@proton.me"));
        participantes.addParticipante(new Participante("equipo 14", "equipo6@proton.me"));
        participantes.addParticipante(new Participante("equipo 15", "equipo7@proton.me"));
        participantes.addParticipante(new Participante("equipo 16", "equipo8@proton.me"));
        participantes.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Eliminacion_Directa, 2, CantidadParticipantes.Dieciseis, participantes);
        System.out.println(calendario.getJornada(0));
        assertEquals(9, calendario.toString());
    }

    @Test
    @DisplayName("Creacion de calendario tipo Eliminacion directa con 2 enfrentamiento y 32 equipos.")
    void crearCalendario32() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Eliminacion_Directa, 2, CantidadParticipantes.TreintayDos, participantes);
        assertEquals(10, calendario.getCantJornadas());
    }

    @Test
    void getTipoDeCalendario() {
        calendario = new Calendario();
        calendario.setTipoDeCalendario(TipoTorneo.Liga, 1, CantidadParticipantes.Cuatro, participantes);
    }

    @Test
    void setTipoDeCalendario() {

    }

}