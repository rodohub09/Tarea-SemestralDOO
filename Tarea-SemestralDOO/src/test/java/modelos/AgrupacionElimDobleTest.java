package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vistas.PanelPrincipal;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AgrupacionElimDobleTest {
    AgrupacionElimDoble agrupacionElimDoble;
    ArrayList<Participante> participantes;
    Jornada jornada;
    Enfrentamiento enfrentamiento1;
    Enfrentamiento enfrentamiento2;

    @BeforeEach
    void setUp() {
        PanelPrincipal.torneo = new Torneo("Torneo", TipoTorneo.Doble_Eliminacion);
        agrupacionElimDoble = new AgrupacionElimDoble();
        jornada = new Jornada();

        participantes = new ArrayList<>();
        participantes.add(new Participante("Equipo 1", "equipo1@gmail.com"));
        participantes.add(new Participante("Equipo 2", "equipo2@gmail.com"));
        participantes.add(new Participante("Equipo 3", "equipo3@gmail.com"));
        participantes.add(new Participante("Equipo 4", "equipo4@gmail.com"));

        agrupacionElimDoble.organizarParticipantes(participantes);
    }

    @Test
    void testOrganizarParticipantes() {
        assertEquals(4, agrupacionElimDoble.getGanadores().size());
        assertTrue(agrupacionElimDoble.getPerdedores().isEmpty());
    }

    @Test
    void testActualizarParticipantesPrimeraFecha() {
        enfrentamiento1 = new Enfrentamiento(participantes.get(0), participantes.get(1), new Date("04/07/2027"));
        enfrentamiento2 = new Enfrentamiento(participantes.get(2), participantes.get(3), new Date("04/07/2027"));

        enfrentamiento1.setGanador(enfrentamiento1.getLocal());
        enfrentamiento2.setGanador(enfrentamiento2.getVisita());

        jornada.enfrentamientos.add(enfrentamiento1);
        jornada.enfrentamientos.add(enfrentamiento2);
        agrupacionElimDoble.actualizarParticipantes(jornada.enfrentamientos);

        ArrayList<Participante> ganadores = agrupacionElimDoble.getGanadores();
        ArrayList<Participante> perdedores = agrupacionElimDoble.getPerdedores();

        assertEquals(2, ganadores.size());
        assertTrue(perdedores.contains(enfrentamiento1.getVisita()));
        assertTrue(perdedores.contains(enfrentamiento2.getLocal()));
    }

    @Test
    void testDevolverAgrupacionEnFechaImpar() {
        Enfrentamiento e1 = new Enfrentamiento(participantes.get(0), participantes.get(1), new Date());
        Enfrentamiento e2 = new Enfrentamiento(participantes.get(2), participantes.get(3), new Date());
        e1.setGanador(participantes.get(0));
        e2.setGanador(participantes.get(3));

        ArrayList<Enfrentamiento> jornada1 = new ArrayList<>();
        jornada1.add(e1);
        jornada1.add(e2);

        agrupacionElimDoble.actualizarParticipantes(jornada1);
        ArrayList<Participante> activos = agrupacionElimDoble.devolverAgrupacion();

        assertEquals(4, activos.size());
        assertTrue(activos.contains(participantes.get(0)));
        assertTrue(activos.contains(participantes.get(3)));
        assertTrue(activos.contains(participantes.get(1)));
        assertTrue(activos.contains(participantes.get(2)));
    }
}