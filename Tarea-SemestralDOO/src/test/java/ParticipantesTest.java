import modelos.AgrupacionLiga;
import modelos.Participante;
import modelos.Participantes;
import modelos.TipoTorneo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantesTest {
    Participantes participantes = new Participantes();


    @Test
    void getYSetAgrupacionParticipantes() {
        participantes.setAgrupacionParticipantes(TipoTorneo.Liga);
        Class<AgrupacionLiga> agrupacion = AgrupacionLiga.class;
        assertInstanceOf(agrupacion,participantes.getAgrupacionParticipantes());
    }

    @Test
    void agrupar() {
    }

    @Test
    void addParticipanteyDevolverAgrupacion() {
        participantes.setAgrupacionParticipantes(TipoTorneo.Liga);
        participantes.addParticipante(new Participante("Equipo 1", "Equipo1@proton.me"));
        participantes.addParticipante(new Participante("Equipo 2", "Equipo2@proton.me"));
        participantes.addParticipante(new Participante("Equipo 3", "Equipo3@proton.me"));
        participantes.addParticipante(new Participante("Equipo 4", "Equipo4@proton.me"));
        assertNotNull(participantes.devolverAgrupacion());
    }

    @Test
    void getArrayParticipante() {
    }

    @Test
    void getParticipante() {
    }
}