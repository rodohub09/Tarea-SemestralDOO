package modelos;

import vistas.PanelPrincipal;

/**
 * Clase que representa a un participante de un torneo.
 * Mantiene información sobre nombre, contacto y estadísticas dentro del torneo.
 */
public class Participante implements Observer {
    private String nombre;
    private String contacto;
    private int partidosJugados;
    private int wins;
    private int losses;
    private int draws;
    private int puntos;

    /**
     * Constructor que inicializa un participante con nombre y contacto.
     * @param nombre Nombre del participante.
     * @param contacto Información de contacto del participante.
     */
    public Participante(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.partidosJugados = 0;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.puntos = 0;
    }

    /**
     * Registra el resultado de un partido, actualizando las estadísticas del participante.
     * Solo se registra si el número de partidos jugados coincide con la jornada actual del torneo.
     *
     * @param resultado Resultado del partido (Victoria, derrota o empate).
     */
    @Override
    public void registrarResultado(Resultados resultado) {
        if(partidosJugados == PanelPrincipal.torneo.getNumJornada()){
            partidosJugados++;
            switch (resultado) {
                case Victoria -> {
                wins++;
                puntos += 3;
                }
                case Derrota -> losses++;
                case Empate -> {
                  draws++;
                  puntos += 1;
                }
            }
        }
    }

    /**
     * Getter del nombre del participante.
     * @return Nombre del participante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter del contacto del participante.
     * @return Contacto del participante.
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Getter de la cantidad de partidos jugados del participante.
     * @return Cantidad de partidos jugados del participante.
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }

    /**
     * Getter de la cantidad de partidos ganados del participante.
     * @return Cantidad de partidos ganados del participante.
     */
    public int getWins() {
        return wins;
    }

    /**
     * Getter de la cantidad de partidos perdidos del participante.
     * @return Cantidad de partidos perdidos del participante.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Getter de la cantidad de partidos empatados del participante.
     * @return Cantidad de partidos empatados del participante.
     */
    public int getDraws() {
        return draws;
    }

    /**
     * Getter de la cantidad de puntos obtenidos del participante.
     * @return Cantidad de puntos obtenidos del participante.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Setter de la cantidad de partidos jugados del participante.
     * @param partidosJugados Cantidad de partidos jugados del participante.
     */
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    /**
     * Setter de la cantidad de partidos ganados del participante.
     * @param wins Cantidad de partidos ganados del participante.
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Setter del nombre del participante.
     * @param nombre Nombre del participante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter de la cantidad de partidos empatados del participante.
     * @param draws Cantidad de partidos empatados del participante.
     */
    public void setDraws(int draws) {
        this.draws = draws;
    }

    /**
     * Setter de la cantidad de partidos perdidos del participante.
     * @param losses Cantidad de partidos perdidos del participante.
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * Setter de la cantidad de puntos obtenidos del participante.
     * @param puntos Cantidad de puntos obtenidos del participante.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Setter del contacto del participante.
     * @param contacto Contacto del participante.
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * Representacion en texto del participante mediante sus datos.
     * @return Cadena con el nombre y contacto del participante.
     */
    public String toString(){
        return this.nombre + " Contacto: " + this.contacto + "\n";
    }
}