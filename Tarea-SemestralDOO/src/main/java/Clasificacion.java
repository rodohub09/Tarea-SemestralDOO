import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Clasificacion implements AgrupacionParticipantes {
    private Map<Participante, Vector> clasificacion;

    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        for(Participante p : participantes){
            clasificacion.put(p,new Vector<>(6));
        }
    }
}
