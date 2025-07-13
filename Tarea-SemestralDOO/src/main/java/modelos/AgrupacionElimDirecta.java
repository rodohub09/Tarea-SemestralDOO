package modelos;
import java.util.ArrayList;

public class AgrupacionElimDirecta implements AgrupacionParticipantes {
    private ArrayList<Participante> bracket1;
    private ArrayList<Participante> bracket2;
    private ArrayList<Participante> participantesActivos;

    public AgrupacionElimDirecta(){
        this.bracket1 = new ArrayList<>();
        this.bracket2 = new ArrayList<>();
        this.participantesActivos = new ArrayList<>();
    }

    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        for(int i = 0; i < participantes.size() / 2; i++){
            Participante p1 = participantes.get(i);
            Participante p2 = participantes.get(participantes.size() - i - 1);
            bracket1.add(p1);
            bracket2.add(p2);
        }
        participantesActivos.addAll(participantes);
    }

    public void actualizarParticipantes(ArrayList<Enfrentamiento> enfrentamientos) {
        ArrayList<Participante> activos = new ArrayList<>();
        for (Enfrentamiento e : enfrentamientos) {
            Participante ganador = e.getGanador();
            if (ganador != null)
                activos.add(ganador);
        }
        this.participantesActivos = activos;
    }

    @Override
    public ArrayList<Participante> devolverAgrupacion() {
        return new ArrayList<>(participantesActivos);
    }

    @Override
    public String toString() {
        return bracket1.toString() + bracket2.toString() + participantesActivos.toString();
    }
}