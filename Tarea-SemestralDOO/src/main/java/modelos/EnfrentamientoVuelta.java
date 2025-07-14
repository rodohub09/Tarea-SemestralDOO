package modelos;

import java.util.Date;

/**
 * Clase que representa un enfrentamiento de vuelta en una serie de ida y vuelta.
 * Extiende la clase {@link Enfrentamiento} e incluye referencia al enfrentamiento de ida.
 */
public class EnfrentamientoVuelta extends Enfrentamiento {
    private Enfrentamiento enfrentamientoIda;
    private Participante ganadorGlobal = null;
    private Participante ganadorDeEstePartido = null;

    /**
     * Constructor del enfrentamiento de vuelta.
     *
     * @param local          Participante local.
     * @param visita         Participante visitante.
     * @param fecha          Fecha del enfrentamiento.
     * @param enfrentamiento Enfrentamiento de ida al cual está vinculado.
     */
    public EnfrentamientoVuelta(Participante local, Participante visita, Date fecha, Enfrentamiento enfrentamiento) {
        super(local, visita, fecha);
        this.enfrentamientoIda = enfrentamiento;
    }

    /**
     * Establece el ganador global considerando partido de ida y partido de vuelta.
     *
     * @param ganadorGlobal Participante que ganó la serie.
     */
    public void setGanador(Participante ganadorGlobal) {
        this.ganadorGlobal = ganadorGlobal;
    }

    /**
     * Getter del ganador de la serie.
     *
     * @return Participante ganador de la serie.
     */
    public Participante getGanador() {
        return ganadorGlobal;
    }

    /**
     * Getter del ganador del partido de vuelta.
     *
     * @return Participante ganador del partido de vuelta.
     */
    public Participante getGanadorDeEstePartido() {
        return ganadorDeEstePartido;
    }

    /**
     * Establece el ganador del partido de vuelta.
     *
     * @param ganadorDeEstePartido Participante ganador del partido de vuelta.
     */
    public void setGanadorDeEstePartido(Participante ganadorDeEstePartido) {
        this.ganadorDeEstePartido = ganadorDeEstePartido;
    }
}