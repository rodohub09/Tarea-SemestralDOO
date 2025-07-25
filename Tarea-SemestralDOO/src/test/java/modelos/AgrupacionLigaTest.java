package modelos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vistas.PanelPrincipal;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AgrupacionLigaTest {

    static AgrupacionLiga agrupacionLiga = new AgrupacionLiga();
    static ArrayList<Participante> participantes = new ArrayList<>();
    static Enfrentamiento enfrentamiento1;
    static Enfrentamiento enfrentamiento2;

    @BeforeAll
    static void setUp(){
        PanelPrincipal.torneo = new Torneo("aaa",TipoTorneo.Liga);
        participantes.add(new Participante("Equipo 1","jajas@gmail.com"));
        participantes.add(new Participante("Equipo 2","PauBaerer@gmail.com"));
        participantes.add(new Participante("Equipo 3","miHoHatori@outlook.com"));
        participantes.add(new Participante("Equipo 4","Yuka.man@gmail.com"));
        enfrentamiento1 = new Enfrentamiento(participantes.get(0),participantes.get(1),new Date("04/07/2027"));
        enfrentamiento2 = new Enfrentamiento(participantes.get(2),participantes.get(3),new Date("04/07/2027"));
        agrupacionLiga.organizarParticipantes(participantes);
    }

    @Test
    void devolverAgrupacion() {
        assertEquals("Equipo 2",agrupacionLiga.devolverAgrupacion().get(0).getNombre() );
    }

    @Test
    void organizarParticipantes() {
        enfrentamiento1.setGanador(participantes.get(1));
        enfrentamiento2.setEmpate();
        agrupacionLiga.organizarParticipantes(participantes);
        assertEquals("Equipo 2",agrupacionLiga.devolverAgrupacion().get(0).getNombre());
    }

    @Test
    void testToString() {
        assertEquals("[Equipo 2 Contacto: PauBaerer@gmail.com\n" +
                ", Equipo 3 Contacto: miHoHatori@outlook.com\n" +
                ", Equipo 4 Contacto: Yuka.man@gmail.com\n" +
                ", Equipo 1 Contacto: jajas@gmail.com\n" +
                "]",agrupacionLiga.toString());
    }
}