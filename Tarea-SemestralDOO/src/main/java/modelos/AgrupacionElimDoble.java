package modelos;

import java.util.ArrayList;


/**
 * Clase que representa la agrupación de {@link Participantes} en un {@link Torneo} de eliminación doble.
 * Divide a los participantes en dos brackets: ganadores y perdedores, y actualiza sus estados a medida que avanza el torneo.
 */
public class AgrupacionElimDoble implements AgrupacionParticipantes {
    private ArrayList<Participante> ganadores;
    private ArrayList<Participante> perdedores;

    /**
     * Constructor que inicializa las llaves de ganadores y perdedores.
     */
    public AgrupacionElimDoble() {
        this.ganadores = new ArrayList<>();
        this.perdedores = new ArrayList<>();
    }

    /**
     * Organiza a todos los participantes en el bracket de ganadores al inicio del torneo.
     * @param participantes Lista inicial de participantes.
     */
    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        ganadores.clear();
        perdedores.clear();
        ganadores.addAll(participantes);
    }

    /**
     * Actualiza el Upper Bracket tras una ronda, moviendo a los perdedores a una lista de perdedores (Lower Bracket).
     * @param enfrentamientos Lista de enfrentamientos en el Upper Bracket.
     */
    public void actualizarUpperBracket(ArrayList<Enfrentamiento> enfrentamientos) {
        ArrayList<Participante> nuevosGanadores = new ArrayList<>();
        for (Enfrentamiento e : enfrentamientos) {
            Participante ganador = e.getGanador();
            if (ganador != null) {
                nuevosGanadores.add(ganador);
                Participante perdedor = e.getLocal() == ganador ? e.getVisita() : e.getLocal();
                perdedores.add(perdedor);
            }
        }
        ganadores = nuevosGanadores;
    }


    /**
     * Actualiza el Lower Bracket manteniendo solo a los ganadores de dicha ronda.
     * @param enfrentamientos Enfrentamientos disputados en el Lower Bracket.
     */
    public void actualizarLowerBracket(ArrayList<Enfrentamiento> enfrentamientos) {
        ArrayList<Participante> nuevosPerdedores = new ArrayList<>();
        for (Enfrentamiento e : enfrentamientos) {
            Participante ganador = e.getGanador();
            if (ganador != null)
                nuevosPerdedores.add(ganador);
        }
        perdedores = nuevosPerdedores;
    }

    /**
     * Devuelve la lista de todos los participantes activos en el torneo, incluyendo ambos Brackets.
     * @return Lista de participantes activos.
     */
    @Override
    public ArrayList<Participante> devolverAgrupacion() {
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.addAll(ganadores);
        participantes.addAll(perdedores);
        return participantes;
    }

    /**
     * Getter de la lista de participantes en el Upper Bracket.
     * @return Lista de participantes en el Upper Bracket.
     */
    public ArrayList<Participante> getGanadores() {
        return ganadores;
    }

    /**
     * Getter de la lista de participantes en el Lower Bracket.
     * @return Lista de participantes en el Lower Bracket.
     */
    public ArrayList<Participante> getPerdedores() {
        return perdedores;
    }

    /**
     * Devuelve una representación en texto del estado del torneo y los participantes activos.
     * @return Cadena con el estado actual del torneo.
     */
    @Override
    public String toString() {
        return "Upper Bracket: " + ganadores.toString() + "\nLower Bracket: " + perdedores.toString();
    }
}