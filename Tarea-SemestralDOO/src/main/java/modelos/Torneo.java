package modelos;

public class Torneo {
    private String nombre;
    private TipoTorneo tipoTorneo;
    private Calendario calendario;
    private CantidadParticipantes cantidadParticipantes;
    private Participantes participantes;
    private int jornada = 0;
    private String descripcion;
    private String disciplina;

    public Torneo(String nombre, TipoTorneo Torneo) {
        participantes = new Participantes();
        tipoTorneo = Torneo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public TipoTorneo getTipoTorneo() {
        return tipoTorneo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setCantidadParticipantes(CantidadParticipantes cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public void setTipoTorneo(TipoTorneo tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }
}