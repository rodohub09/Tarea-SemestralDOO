package modelos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Clasificacion implements AgrupacionParticipantes {
    private Map<Participante, Vector> clasificacion;

    public Clasificacion(){
        this.clasificacion = new HashMap<>();
    }

    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        for(Participante p : participantes){
            clasificacion.put(p,new Vector<>(6));
        }
    }

    @Override
    public String toString() {
        return clasificacion.toString();
    }
}
