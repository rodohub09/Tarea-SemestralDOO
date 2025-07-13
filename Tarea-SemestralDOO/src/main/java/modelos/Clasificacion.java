package modelos;

import java.util.*;
import java.util.Comparator;

public class Clasificacion implements AgrupacionParticipantes{
    private ArrayList<Participante> clasificacion;

    public Clasificacion(){
        this.clasificacion = new ArrayList<>();
    }

    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        clasificacion.addAll(participantes);
        clasificacion.sort(Comparator.comparingInt(Participante::getPuntos).reversed());
    }

    public ArrayList<Participante> devolverAgrupacion() {
        return clasificacion;
    }

    @Override
    public String toString() {
        return clasificacion.toString();
    }
}
