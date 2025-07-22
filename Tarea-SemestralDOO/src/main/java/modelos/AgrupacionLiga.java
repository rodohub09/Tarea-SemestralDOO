package modelos;

import java.util.*;
import java.util.Comparator;

/**
 * Clase que representa la agrupación de {@link Participantes} en un {@link Torneo} de tipo liga.
 * Organiza a los participantes, de mayor a menor, según sus puntos obtenidos.
 */
public class AgrupacionLiga implements AgrupacionParticipantes{
    private ArrayList<Participante> clasificacion;

    /**
     * Constructor que inicializa la lista de clasificación vacía.
     */
    public AgrupacionLiga(){
        this.clasificacion = new ArrayList<>();
    }

    /**
     * Organiza a los participantes según su puntaje, en orden descendente.
     * @param participantes Lista de participantes a ordenar.
     */
    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        clasificacion.clear();
        clasificacion.addAll(participantes);
        clasificacion.sort(Comparator.comparingInt(Participante::getPuntos).reversed());
    }

    /**
     * Devuelve la lista de participantes del torneo.
     * @return Lista de participantes.
     */
    public ArrayList<Participante> devolverAgrupacion() {
        return clasificacion;
    }

    @Override
    public void actualizarParticipantes(ArrayList<Enfrentamiento> enfrentamientos) {

    }

    /**
     * Devuelve una representación en texto del estado del torneo y los participantes activos.
     * @return Cadena con el estado actual del torneo.
     */
    @Override
    public String toString() {
        String s = "";

        for(Participante p: clasificacion){
            s += p.toString();
        }

        return clasificacion.toString();
    }
}