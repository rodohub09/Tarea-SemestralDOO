package modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TorneoTest {
    Torneo torneo = new Torneo("Torneo", TipoTorneo.Liga);

    @Test
    void getNombre() {
        assertEquals("Torneo",torneo.getNombre());
    }

    @Test
    void setNombre() {
        torneo.setNombre("Cambio de torneo");
        assertEquals("Cambio de torneo",torneo.getNombre());
    }

    @Test
    void getParticipantes() {
        assertEquals(0,torneo.getParticipantes().participantes.size());
    }

    @Test
    void getCalendario() {
        assertEquals(0,torneo.getCalendario().getCantJornadas());
    }

    @Test
    void getNumJornada() {
        assertEquals(0,torneo.getNumJornada());
    }

    @Test
    void getDescripcion() {
        assertNull(torneo.getDescripcion());
    }

    @Test
    void getDisciplina() {
        assertNull(torneo.getDisciplina());
    }

    @Test
    void getCantidadParticipantes() {
        assertNull(torneo.getCantidadParticipantes());
    }

    @Test
    void getFormato() {
        assertNull(torneo.getFormato());
    }

    @Test
    void getTipoTorneo() {
        assertEquals(TipoTorneo.Liga,torneo.getTipoTorneo());
    }

    @Test
    void setDescripcion() {
        torneo.setDescripcion("Holi");
        assertEquals("Holi",torneo.getDescripcion());
    }

    @Test
    void setDisciplina() {
        torneo.setDisciplina("Futebol");
        assertEquals("Futebol",torneo.getDisciplina());
    }

    @Test
    void setCantidadParticipantes() {
        torneo.setCantidadParticipantes(CantidadParticipantes.Cuatro);
        assertEquals(CantidadParticipantes.Cuatro,torneo.getCantidadParticipantes());
    }

    @Test
    void setTipoTorneo() {
        torneo.setTipoTorneo(TipoTorneo.Eliminacion_Directa);
        assertEquals(TipoTorneo.Eliminacion_Directa,torneo.getTipoTorneo());
    }

    @Test
    void setFormato() {
        torneo.setFormato(Formato.Ida_y_Vuelta);
        assertEquals(Formato.Ida_y_Vuelta,torneo.getFormato());
    }

    @Test
    void setCalendario() {
        torneo.setCalendario(new Calendario());
        assertNotNull(torneo.getCalendario());
    }

    @Test
    void incJornada() {
        torneo.incJornada();
        assertEquals(1, torneo.getNumJornada());
    }
}