package modelos;
import java.util.ArrayList;

/**
 * Clase que representa una jornada dentro de un torneo.
 * Una jornada contiene una lista de enfrentamientos con sus respectivos participantes.
 */
public class Jornada {
    public ArrayList<Enfrentamiento> enfrentamientos;
    private Participantes participantes;

    /**
     * Constructor que inicializa la jornada con la lista de participantes.
     * @param participantes Participantes disponibles en el torneo.
     */
    public Jornada(Participantes participantes){
        this.enfrentamientos = new ArrayList<>();
        this.participantes = participantes;
    }

    /**
     * Getter de la lista de enfrentamientos de la jornada.
     * @return Lista de enfrentamientos de la jornada.
     */
    public ArrayList<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    /**
     * Getter de la lista de todos los participantes de la jornada.
     * @return Lista de participantes de la jornada.
     */
    public Participantes getParticipantes() {
        return participantes;
    }

    /**
     * Representacion en texto de todos los enfrentamientos de la jornada.
     * @return Cadena con todos los enfrentamientos de la jornada.
     */
    public String toString(){
        String s = "";
        for(int i=0;i<enfrentamientos.size();i++){
            s += enfrentamientos.get(i) + "\n";
        }
        return s;
    }
}