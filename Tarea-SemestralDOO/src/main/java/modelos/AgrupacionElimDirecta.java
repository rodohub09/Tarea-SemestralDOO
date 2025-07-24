package modelos;
import java.util.ArrayList;

/**
 * Clase que representa la agrupación de {@link Participantes} en un {@link Torneo} de eliminación directa.
 * Administra los brackets iniciales y los {@link Participantes} que permanecen a lo largo del {@link Torneo}.
 */
public class AgrupacionElimDirecta implements AgrupacionParticipantes {
    private ArrayList<Participante> bracket1;
    private ArrayList<Participante> bracket2;
    private ArrayList<Participante> participantesActivos;

    /**
     * Constructor que inicializa los brackets y la lista de participantes activos.
     */
    public AgrupacionElimDirecta(){
        this.bracket1 = new ArrayList<>();
        this.bracket2 = new ArrayList<>();
        this.participantesActivos = new ArrayList<>();
    }

    /**
     * Organiza a los participantes en dos brackets emparejando en un mismo enfrentamiento a los participantes ubicados en los extremos de la lista.
     * @param participantes Lista de participantes del torneo.
     */
    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        for(int i = 0; i < participantes.size() / 2; i++){
            if(i<participantes.size()/4){
                Participante p1 = participantes.get(i);
                Participante p2 = participantes.get(participantes.size() - i - 1);
                bracket1.add(p1);
                bracket1.add(p2);
            }else{
                Participante p1 = participantes.get(i);
                Participante p2 = participantes.get(participantes.size() - i - 1);
                bracket2.add(p1);
                bracket2.add(p2);
            }
        }
        participantesActivos.addAll(participantes);
    }

    /**
     * Actualiza la lista de participantes activos según los ganadores de los enfrentamientos.
     * @param enfrentamientos Lista de enfrentamientos de la jornada actual.
     */
    @Override
    public void actualizarParticipantes(ArrayList<Enfrentamiento> enfrentamientos) {
        ArrayList<Participante> activos = new ArrayList<>();
        ArrayList<Participante> activosOrdenados = new ArrayList<>();
        for (Enfrentamiento e : enfrentamientos) {
            Participante ganador = e.getGanador();
            if (ganador != null)
                activos.add(ganador);
        }

        if (activos.size() == 1) {
            this.participantesActivos = activos;
            return;
        }

        for(int i=0;i< activos.size()/2;i++){
            activosOrdenados.add(activos.get(i*2));
        }
        for(int i= activos.size()-1;0<i;i-=2){
            activosOrdenados.add(activos.get(i));
        }
        this.participantesActivos = activosOrdenados;
    }

    /**
     * Devuelve la lista de los participantes activos del torneo.
     * @return Lista de participantes activos.
     */
    @Override
    public ArrayList<Participante> devolverAgrupacion() {
        return this.participantesActivos;
    }

    /**
     * Devuelve la lista del primer bracket.
     * @return Bracket 1.
     */
    public ArrayList<Participante> getBracket1() {
        return bracket1;
    }

    /**
     * Devuelve la lista del segundo bracket.
     * @return Bracket 2.
     */
    public ArrayList<Participante> getBracket2() {
        return bracket2;
    }

    /**
     * Devuelve una representación en texto del estado del torneo y los participantes activos.
     * @return Cadena con el estado actual del torneo.
     */
    @Override
    public String toString() {
        return bracket1.toString() + bracket2.toString() + participantesActivos.toString();
    }
}