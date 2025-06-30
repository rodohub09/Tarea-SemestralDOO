import java.util.ArrayList;

public class Participantes {
    private AgrupacionParticipantes agrupacionParticipantes;
    private ArrayList<Participante> participantes;

    public Participantes(){
        this.participantes = new ArrayList<>();
    }

    public void setAgrupacionParticipantes(TipoTorneo tipoTorneo){
        switch (tipoTorneo){
            case Liguilla -> agrupacionParticipantes = new Clasificacion();
            case FaseGrupos -> agrupacionParticipantes = new Grupos();
            case EliminacionDirecta -> agrupacionParticipantes = new Bracket();
        }
    }

    public void agrupar(){
        agrupacionParticipantes.organizarParticipantes(participantes);
    }

    public void addParticipante(Participante participante){
        participantes.add(participante);
    }

    @Override
    public String toString() {
        return agrupacionParticipantes.toString();
    }
}