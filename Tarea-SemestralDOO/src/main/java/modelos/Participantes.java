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
            case Eliminacion_Directa -> agrupacionParticipantes = new Bracket();
        }
    }

    public void agrupar(){
        agrupacionParticipantes.organizarParticipantes(participantes);
    }

    public ArrayList<Participante> devolverAgrupacion(){
        return agrupacionParticipantes.devolverAgrupacion();
    }

    public void addParticipante(Participante participante){
        participantes.add(participante);
    }

    public ArrayList<Participante> getArrayParticipante() {
        return participantes;
    }

    public Participante getParticipante(int i){
        return participantes.get(i);
    }

    @Override
    public String toString() {
        return agrupacionParticipantes.toString();
    }
}