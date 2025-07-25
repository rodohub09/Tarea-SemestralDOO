package modelos;

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
    void addParticipanteyDevolverAgrupacion() {
        participantes.setAgrupacionParticipantes(TipoTorneo.Liga);
        participantes.addParticipante(new Participante("Equipo 1", "Equipo1@proton.me"));
        participantes.addParticipante(new Participante("Equipo 2", "Equipo2@proton.me"));
        participantes.addParticipante(new Participante("Equipo 3", "Equipo3@proton.me"));
        participantes.addParticipante(new Participante("Equipo 4", "Equipo4@proton.me"));
        assertNotNull(participantes.devolverAgrupacion());
    }

    @Test
    void agrupar(){
        participantes.setAgrupacionParticipantes(TipoTorneo.Liga);
        participantes.addParticipante(new Participante("Equipo 1", "Equipo1@proton.me"));
        participantes.addParticipante(new Participante("Equipo 2", "Equipo2@proton.me"));
        participantes.addParticipante(new Participante("Equipo 3", "Equipo3@proton.me"));
        participantes.addParticipante(new Participante("Equipo 4", "Equipo4@proton.me"));
        participantes.agrupar();
        assertEquals("[Equipo 1 Contacto: Equipo1@proton.me\n" +
                ", Equipo 2 Contacto: Equipo2@proton.me\n" +
                ", Equipo 3 Contacto: Equipo3@proton.me\n" +
                ", Equipo 4 Contacto: Equipo4@proton.me\n" +
                "]",participantes.getAgrupacionParticipantes().devolverAgrupacion().toString());
    }

    @Test
    void getArrayParticipante(){
        assertEquals("[]",participantes.getArrayParticipante().toString());
    }

    @Test
    void getParticipante(){
        participantes.setAgrupacionParticipantes(TipoTorneo.Liga);
        participantes.addParticipante(new Participante("Equipo 1", "Equipo1@proton.me"));
        participantes.addParticipante(new Participante("Equipo 2", "Equipo2@proton.me"));
        assertEquals("Equipo 1 Contacto: Equipo1@proton.me\n",participantes.getParticipante(0).toString());
        assertEquals("Equipo 2 Contacto: Equipo2@proton.me\n",participantes.getParticipante(1).toString());
    }
}