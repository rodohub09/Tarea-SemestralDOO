package modelos;

/**
 * Clase que representa un torneo, incluyendo su configuración, participantes y calendario.
 */
public class Torneo {
    private String nombre;
    private String descripcion;
    private String disciplina;
    private TipoTorneo tipoTorneo;
    private Calendario calendario;
    private CantidadParticipantes cantidadParticipantes;
    private Participantes participantes;
    private Formato formato;
    private int jornada = 0;
    private AgrupacionParticipantes agrupacionParticipantes;      //OJOOOOO

    /**
     * Constructor que crea un torneo con el nombre y tipo de torneo especificados.
     * @param nombre Nombre del torneo.
     * @param Torneo Tipo de torneo (Liga, eliminación directa o doble eliminación).
     */
    public Torneo(String nombre, TipoTorneo Torneo) {
        participantes = new Participantes();
        calendario = new Calendario();
        tipoTorneo = Torneo;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del nombre del torneo.
     * @return Nombre del torneo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de los participantes del torneo.
     * @return Lista de participantes del torneo.
     */
    public Participantes getParticipantes() {
        return participantes;
    }

    /**
     * Getter del calendario del torneo.
     * @return Calendario del torneo.
     */
    public Calendario getCalendario() {
        return calendario;
    }

    /**
     * Getter del número de la jornada actual.
     * @return Número de jornada.
     */
    public int getNumJornada() {
        return jornada;
    }

    /**
     * Getter de la descripción del torneo.
     * @return Descripción del torneo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Getter de la disciplina del torneo.
     * @return Disciplina del torneo.
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * Getter de la cantidad de participantes del torneo.
     * @return Cantidad de participantes del torneo.
     */
    public CantidadParticipantes getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    /**
     * Getter del formato del torneo (Solo ida o ida-vuelta).
     * @return Formato del torneo.
     */
    public Formato getFormato() {
        return formato;
    }

    /**
     * Getter del tipo de torneo.
     * @return Tipo de torneo.
     */
    public TipoTorneo getTipoTorneo() {
        return tipoTorneo;
    }

    /**
     * Setter de la descripción del torneo.
     * @param descripcion Descripción del torneo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Setter de la disciplina del torneo.
     * @param disciplina Disciplina del torneo.
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Setter de la cantidad de participantes del torneo.
     * @param cantidadParticipantes Cantidad de participantes del torneo.
     */
    public void setCantidadParticipantes(CantidadParticipantes cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    /**
     * Setter del tipo de torneo.
     * @param tipoTorneo Tipo de torneo.
     */
    public void setTipoTorneo(TipoTorneo tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }

    /**
     * Setter del formato del torneo.
     * @param formato Formato del torneo.
     */
    public void setFormato(Formato formato){
        this.formato = formato;
    }

    /**
     * Setter del calendario del torneo.
     * @param calendario Calendario del torneo.
     */
    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    /**
     * Incrementa en uno el número de jornada.
     */
    public void incJornada(){
        jornada++;
    }

    /**
     * Getter de la agrupación de participantes del torneo.
     * @return Nombre del torneo.
     */
    public AgrupacionParticipantes getAgrupacionParticipantes() {
        return this.agrupacionParticipantes;
    }

    /**
     * Asigna una agrupación de participantes al torneo.
     * @param agrupacionParticipantes Agrupación a asignar.
     */
    public void setAgrupacionParticipantes(AgrupacionParticipantes agrupacionParticipantes) {
        this.agrupacionParticipantes = agrupacionParticipantes;
    }

    public boolean torneoFinalizado() {
        switch (tipoTorneo) {
            case Liga -> {return getNumJornada() >= calendario.getCantJornadas();}
            case Eliminacion_Directa -> {return getNumJornada() >= cantidadParticipantes.getJornadasElimDirecta();}
        }
        return false;
    }

    public Participante getCampeon() {
        if (!torneoFinalizado()) return null;
        Participante campeon = null;

        switch (tipoTorneo) {
            case Liga -> {
                int maxPuntos = -1;
                for (Participante p : participantes.devolverAgrupacion()) {
                    if (p.getPuntos() > maxPuntos) {
                        campeon = p;
                        maxPuntos = p.getPuntos();
                    } else if (p.getPuntos() == maxPuntos) {
                        assert campeon != null;
                        if (p.getWins() > campeon.getWins()) {
                            campeon = p;
                        }
                    }
                }
            }
            case Eliminacion_Directa, Doble_Eliminacion -> {
                int maxWins = -1;
                for (Participante p : participantes.devolverAgrupacion()) {
                    if (p.getWins() > maxWins) {
                        campeon = p;
                        maxWins = p.getWins();
                    }
                }
            }
        }
        return campeon;
    }
}