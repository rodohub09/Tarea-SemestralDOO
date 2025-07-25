package modelos;

import java.util.ArrayList;


/**
 * Clase que representa la agrupación de {@link Participantes} en un {@link Torneo} de eliminación doble.
 * Divide a los participantes en dos brackets: ganadores y perdedores, y actualiza sus estados a medida que avanza el torneo.
 */
public class AgrupacionElimDoble implements AgrupacionParticipantes {
    private ArrayList<Participante> ganadores;
    private ArrayList<Participante> perdedores;
    private boolean penultimo = false;
    public int fecha = 0;

    /**
     * Constructor que inicializa las llaves de ganadores y perdedores.
     */
    public AgrupacionElimDoble() {
        this.ganadores = new ArrayList<>();
        this.perdedores = new ArrayList<>();
        fecha++;
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
        if(fecha%2 == 0){
            ArrayList<Participante> participantes = new ArrayList<>();
            for(int i=0;i<this.perdedores.size();i+=2){
                participantes.add(perdedores.get(i));
            }
            for(int i=this.perdedores.size()-1;0<i;i-=2){
                participantes.add(perdedores.get(i));
            }
            return participantes;
        }else{
            ArrayList<Participante> participantes = new ArrayList<>();
            participantes.addAll(ganadores);
            participantes.addAll(perdedores);
            return participantes;
        }
    }

    /**
     * Actualiza la lista de participantes activos según los ganadores de los enfrentamientos.
     * @param enfrentamientos Lista de enfrentamientos de la jornada actual.
     */
    @Override
    public void actualizarParticipantes(ArrayList<Enfrentamiento> enfrentamientos) {
        int mitad = enfrentamientos.size()/2;
        ArrayList<Participante> upperBracket = new ArrayList<>();
        ArrayList<Participante> lowerBracket = new ArrayList<>();
        if(fecha==0){
            for(int i=0;i<enfrentamientos.size();i++){
                upperBracket.add(enfrentamientos.get(i).getGanador());
                lowerBracket.add(enfrentamientos.get(i).getPerdedor());
            }
        }else if ((mitad == 0) && (!penultimo)){
            upperBracket.add(ganadores.get(0));
            upperBracket.add(enfrentamientos.get(0).getGanador());
            penultimo = true;
        } else if (fecha%2 != 0) {
            upperBracket.addAll(this.ganadores);
            for(int i=mitad;i<enfrentamientos.size();i++){
                lowerBracket.add(enfrentamientos.get(i).getGanador());
            }
        }else{
            for(int i=0;i<enfrentamientos.size();i++){
                if(i<mitad){
                    upperBracket.add(enfrentamientos.get(i).getGanador());
                    lowerBracket.add(enfrentamientos.get(i).getPerdedor());
                }else{
                    lowerBracket.add(enfrentamientos.get(i).getGanador());
                }
            }
        }
        this.ganadores = upperBracket;
        this.perdedores = lowerBracket;
        fecha++;
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