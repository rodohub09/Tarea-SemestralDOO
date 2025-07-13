import modelos.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class JornadaTest {
    private static Jornada jornada;

    @BeforeAll
    static void setUp(){
        Participantes participantes = new Participantes();
        participantes.addParticipante(new Participante("Equipo 1"));
        participantes.addParticipante(new Participante("Equipo 2"));
        participantes.addParticipante(new Participante("Equipo 3"));
        participantes.addParticipante(new Participante("Equipo 4"));
        Enfrentamiento enfrentamiento1 = new Enfrentamiento(participantes.getParticipante(0),participantes.getParticipante(1),new Date("04/07/2027"));
        Enfrentamiento enfrentamiento2 = new Enfrentamiento(participantes.getParticipante(2),participantes.getParticipante(3),new Date("04/07/2027"));
        jornada = new Jornada(participantes, TipoTorneo.Liga);
        jornada.partidos.add(enfrentamiento1);
        jornada.partidos.add(enfrentamiento2);
    }


    @Test
    void getPartidos() {
        assertNotNull(jornada.getPartidos());
    }

    @Test
    void testToString() {
        assertEquals("Partido: Equipo 1 vs Equipo 2\nPartido: Equipo 3 vs Equipo 4\n",jornada.toString());
    }
}