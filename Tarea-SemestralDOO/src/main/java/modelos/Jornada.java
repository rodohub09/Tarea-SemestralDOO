package modelos;
import java.util.ArrayList;

/**
 * Clase que representa una jornada dentro de un torneo.
 * Una jornada contiene una lista de enfrentamientos con sus respectivos participantes.
 */
public class Jornada {
    public ArrayList<Enfrentamiento> enfrentamientos;

    /**
     * Constructor que inicializa la jornada con la lista de participantes.
     */
    public Jornada(){
        this.enfrentamientos = new ArrayList<>();
    }

    /**
     * Getter de la lista de enfrentamientos de la jornada.
     * @return Lista de enfrentamientos de la jornada.
     */
    public ArrayList<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    /**
     * Representacion en texto de todos los enfrentamientos de la jornada.
     * @return Cadena con todos los enfrentamientos de la jornada.
     */
    public String toString(){
        String s = "";
        for(int i=0;i<enfrentamientos.size();i++){
            s += enfrentamientos.get(i).toString() + "\n";
        }
        return s;
    }
}