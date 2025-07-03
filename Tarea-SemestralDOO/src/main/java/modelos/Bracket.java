package modelos;
import java.util.ArrayList;

public class Bracket implements AgrupacionParticipantes{
    private ArrayList<Participante> bracket1;
    private ArrayList<Participante> bracket2;

    public Bracket(){
        this.bracket1 = new ArrayList<>();
        this.bracket2 = new ArrayList<>();
    }

    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        for(int i = 0; i < participantes.size()/2; i++){
            bracket1.add(participantes.get(i));
            bracket2.add(participantes.get(participantes.size()-(i+1)));
        }
    }

    @Override
    public String toString() {
        return bracket1.toString() + bracket2.toString();
    }
}
