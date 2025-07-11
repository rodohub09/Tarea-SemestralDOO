package modelos;
import java.util.ArrayList;

public class Participantes {
    private AgrupacionParticipantes agrupacionParticipantes;
    public ArrayList<Participante> participantes;

    public Participantes(){
        this.participantes = new ArrayList<>();
    }

    public void setAgrupacionParticipantes(TipoTorneo tipoTorneo){
        switch (tipoTorneo){
            case Liga -> agrupacionParticipantes = new Clasificacion();
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

    public Participante getParticipante(int i){
        return participantes.get(i);
    }

    @Override
    public String toString() {
        return agrupacionParticipantes.toString();
    }
}