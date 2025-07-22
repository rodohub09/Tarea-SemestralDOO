package modelos;

/**
 * Enum que representa diferentes cantidades de participantes para un torneo,
 * junto con configuraciones particulares para enfrentamientos y jornadas según el tipo de torneo.
 */
public enum CantidadParticipantes {
    Cuatro(4, 2, 2, 3,2),
    Ocho(8, 4, 3, 7,3),
    Dieciseis(16, 8, 4, 15,4),
    TreintayDos(32, 16, 5, 31,5);

    private final int numParticipantes;
    private final int enfrentamientosXJornadaLiga;
    private final int enfrentamientosXJornadaElimDirecta;
    private final int jornadasLiga;
    private final int jornadasElimDirecta;

    /**
     * Constructor para inicializar las propiedades de cada constante.
     *
     * @param numParticipantes Número total de participantes.
     * @param enfrentamientosXJornada Liga: cantidad de enfrentamientos por jornada.
     * @param enfrentamientosXJornadaElimDirecta Eliminación directa: enfrentamientos por jornada.
     * @param jornadasLiga Número total de jornadas en formato liga.
     */
    CantidadParticipantes(int numParticipantes, int enfrentamientosXJornada, int enfrentamientosXJornadaElimDirecta, int jornadasLiga, int jornadasElimDirecta) {
        this.numParticipantes = numParticipantes;
        this.enfrentamientosXJornadaLiga = enfrentamientosXJornada;
        this.enfrentamientosXJornadaElimDirecta = enfrentamientosXJornadaElimDirecta;
        this.jornadasLiga = jornadasLiga;
        this.jornadasElimDirecta = enfrentamientosXJornadaElimDirecta;
    }

    /**
     * Getter del número total de participantes.
     * @return Número de participantes.
     */
    public int getNumParticipantes() {
        return numParticipantes;
    }

    /**
     * Getter de la cantidad de enfrentamientos por jornada en formato liga.
     * @return Enfrentamientos por jornada (liga).
     */
    public int getEnfrentamientosXJornadaLiga() {
        return enfrentamientosXJornadaLiga;
    }

    /**
     * Getter de la cantidad de enfrentamientos por jornada en eliminación directa.
     * @return Enfrentamientos por jornada (eliminación directa).
     */
    public int getEnfrentamientosXJornadaElimDirecta() {
        return enfrentamientosXJornadaElimDirecta;
    }

    /**
     * Obtiene el número total de jornadas para formato liga.
     * @return Número de jornadas.
     */
    public int getJornadasLiga() {
        return jornadasLiga;
    }

    /**
     * Representación en texto de la cantidad de participantes.
     * @return Cadena con el número de participantes.
     */
    @Override
    public String toString() {
        return String.valueOf(numParticipantes);
    }
}