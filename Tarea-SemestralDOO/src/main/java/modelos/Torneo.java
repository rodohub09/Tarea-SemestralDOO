package modelos;

public class Torneo {
    private String nombre;
    private TipoTorneo tipoTorneo;
    private Calendario calendario;
    private Participantes participantes;
    private int jornada = 0;

    public Torneo(String nombre, TipoTorneo tipoTorneo) {}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Participantes getParticipantes() {
        return participantes;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public int getNumJornada() {
        return jornada;
    }
}