package modelos;

import org.junit.jupiter.api.Test;
import vistas.PanelPrincipal;

import static org.junit.Assert.assertEquals;

class ParticipanteTest {
    Participante participante = new Participante("fff","fff@yahoo.com");

    @Test
    void registrarResultado() {
        PanelPrincipal.torneo = new Torneo("t1", TipoTorneo.Liga);
        participante.registrarResultado(Resultados.Victoria);
        assertEquals(1,participante.getWins());
    }
}