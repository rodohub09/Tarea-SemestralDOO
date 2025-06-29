import java.util.ArrayList;

//Torneo puede tener una lista de Participantes, pero no sé como conectarlo con la lista de Ronda
public class Participantes {
    private ArrayList<Equipo> participantes;

    public Participantes(){
        this.participantes = new ArrayList<>();
    }

    public void addEquipo(Equipo equipo){
        participantes.add(equipo);
    }
}
