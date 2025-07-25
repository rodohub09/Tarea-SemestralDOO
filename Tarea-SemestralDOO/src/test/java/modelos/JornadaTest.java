package modelos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class JornadaTest {
    private static Jornada jornada;

    @BeforeAll
    static void setUp(){
        Participantes participantes = new Participantes();
        participantes.addParticipante(new Participante("Equipo 1","jajas@gmail.com"));
        participantes.addParticipante(new Participante("Equipo 2","PauBaerer@gmail.com"));
        participantes.addParticipante(new Participante("Equipo 3","miHoHatori@outlook.com"));
        participantes.addParticipante(new Participante("Equipo 4","Yuka.man@gmail.com"));
        Enfrentamiento enfrentamiento1 = new Enfrentamiento(participantes.getParticipante(0),participantes.getParticipante(1),new Date("04/07/2027"));
        Enfrentamiento enfrentamiento2 = new Enfrentamiento(participantes.getParticipante(2),participantes.getParticipante(3),new Date("04/07/2027"));
        jornada = new Jornada();
        jornada.enfrentamientos.add(enfrentamiento1);
        jornada.enfrentamientos.add(enfrentamiento2);
    }


    @Test
    void getPartidos() {
        assertNotNull(jornada.getEnfrentamientos());
    }

    @Test
    void testToString() {
        assertEquals("Partido: Equipo 1 vs Equipo 2\nPartido: Equipo 3 vs Equipo 4\n",jornada.toString());
    }
}