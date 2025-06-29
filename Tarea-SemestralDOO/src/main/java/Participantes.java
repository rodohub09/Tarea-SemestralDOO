import java.util.ArrayList;

public class Participantes {
    private ArrayList<Participante> participantes;

    public Participantes(){
        this.participantes = new ArrayList<>();
    }

    public void addEquipo(Participante participante){
        participantes.add(participante);
    }
}