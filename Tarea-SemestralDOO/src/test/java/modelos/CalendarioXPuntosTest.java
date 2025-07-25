package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class CalendarioXPuntosTest {
    private CalendarioXPuntos calendario;
    private CantidadParticipantes cantidadParticipantes;
    private ArrayList<Jornada> jornadas;
    private Participantes participantes;

    @BeforeEach
    void setUp() {
        participantes = new Participantes();
        participantes.addParticipante(new Participante("equipo 1", "equipo1@proton.me"));
        participantes.addParticipante(new Participante("equipo 2", "equipo2@proton.me"));
        participantes.addParticipante(new Participante("equipo 3", "equipo3@proton.me"));
        participantes.addParticipante(new Participante("equipo 4", "equipo4@proton.me"));
        participantes.setAgrupacionParticipantes(TipoTorneo.Liga);

        cantidadParticipantes = CantidadParticipantes.Cuatro;
        calendario = new CalendarioXPuntos();
        jornadas = new ArrayList<>();
    }

    @Test
    void creacionCalendarioSoloIda() {
        calendario.creacionCalendario(jornadas, 1, cantidadParticipantes, participantes);
        assertEquals(3, jornadas.size());

        for (Jornada jornada : jornadas) {
            assertEquals(2, jornada.enfrentamientos.size());
            for (Enfrentamiento e : jornada.enfrentamientos) {
                assertNotNull(e.getLocal());
                assertNotNull(e.getVisita());
            }
        }
    }

    @Test
    void creacionCalendarioIdaYVuelta() {
        calendario.creacionCalendario(jornadas, 2, cantidadParticipantes, participantes);
        assertEquals(6, jornadas.size());

        for (Jornada jornada : jornadas) {
            assertEquals(2, jornada.enfrentamientos.size());
            for (Enfrentamiento e : jornada.enfrentamientos) {
                assertNotNull(e.getLocal());
                assertNotNull(e.getVisita());
            }
        }
    }
}