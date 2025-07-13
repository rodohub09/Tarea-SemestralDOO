package modelos;
import java.util.ArrayList;

//Podemos usar patrones de diseño para cambiar la forma de crear la ronda dependiendo del tipo de Torneo
public class Jornada {
    public ArrayList<Enfrentamiento> enfrentamientos;
    private Participantes participantes;

    public Jornada(Participantes participantes){
        this.enfrentamientos = new ArrayList<>();
        this.participantes = participantes;
    }

    public ArrayList<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public String toString(){
        String s = "";
        for(int i=0;i<enfrentamientos.size();i++){
            s += enfrentamientos.get(i) + "\n";
        }
        return s;
    }
}