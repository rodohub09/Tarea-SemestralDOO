package modelos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vistas.PanelPrincipal;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgrupacionElimDirectaTest {
    static AgrupacionElimDirecta agrupacionElimDirecta = new AgrupacionElimDirecta();
    static ArrayList<Participante> participantes = new ArrayList<>();
    static Jornada jornada = new Jornada();
    static Enfrentamiento enfrentamiento1;
    static Enfrentamiento enfrentamiento2;

    @BeforeAll
    static void setUp() {
        PanelPrincipal.torneo = new Torneo("Torneo", TipoTorneo.Eliminacion_Directa);
        jornada = new Jornada();
        participantes.add(new Participante("Equipo 1","jajas@gmail.com"));
        participantes.add(new Participante("Equipo 2","PauBaerer@gmail.com"));
        participantes.add(new Participante("Equipo 3","miHoHatori@outlook.com"));
        participantes.add(new Participante("Equipo 4","Yuka.man@gmail.com"));
        enfrentamiento1 = new Enfrentamiento(participantes.get(0), participantes.get(1), new Date("04/07/2027"));
        enfrentamiento2 = new Enfrentamiento(participantes.get(2), participantes.get(3), new Date("04/07/2027"));
        jornada.enfrentamientos.add(enfrentamiento1);
        jornada.enfrentamientos.add(enfrentamiento2);
        agrupacionElimDirecta.organizarParticipantes(participantes);
    }

    @Test
    void actualizarParticipantes() {
        enfrentamiento1.setGanador(enfrentamiento1.getVisita());
        enfrentamiento2.setGanador(enfrentamiento2.getLocal());
        agrupacionElimDirecta.actualizarParticipantes(jornada.enfrentamientos);
        assertEquals("Equipo 2", agrupacionElimDirecta.devolverAgrupacion().getFirst().getNombre());
    }

    @Test
    void organizarParticipantes() {
        enfrentamiento1.setGanador(enfrentamiento1.getLocal());
        enfrentamiento2.setGanador(enfrentamiento2.getVisita());
        agrupacionElimDirecta.organizarParticipantes(participantes);
        assertEquals("Equipo 1", agrupacionElimDirecta.devolverAgrupacion().get(0).getNombre());
    }
}