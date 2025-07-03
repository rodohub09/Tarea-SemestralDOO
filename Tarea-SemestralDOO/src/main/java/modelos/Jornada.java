package modelos;
import java.util.ArrayList;

//Podemos usar patrones de diseño para cambiar la forma de crear la ronda dependiendo del tipo de Torneo
public class Jornada {
    public ArrayList<Enfrentamiento> partidos;
    private Participantes participantes;

    public Jornada(Participantes participantes, TipoTorneo tt){
        this.partidos = new ArrayList<>();
        this.participantes = participantes;
    }

    public ArrayList<Enfrentamiento> getPartidos() {
        return partidos;
    }
}