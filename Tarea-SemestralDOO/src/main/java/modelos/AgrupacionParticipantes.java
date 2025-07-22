package modelos;
import java.util.ArrayList;

/**
 * Interfaz que define la agrupación y organización de participantes en un torneo.
 */
public interface AgrupacionParticipantes {
    /**
     * Organiza y agrupa una lista de participantes según la lógica del tipo de torneo.
     * @param participantes Lista de participantes a organizar.
     */
    void organizarParticipantes(ArrayList<Participante> participantes);

    /**
     * Devuelve la lista de participantes según la agrupación realizada.
     * @return Lista de participantes.
     */
    ArrayList<Participante> devolverAgrupacion();

    void actualizarParticipantes(ArrayList<Enfrentamiento> enfrentamientos);
}
