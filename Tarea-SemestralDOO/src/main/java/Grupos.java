import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Grupos implements AgrupacionParticipantes{
    private Map<String,ArrayList<Map>> grupos;

    public Grupos(){
        this.grupos = new HashMap<>();
    }

    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        ArrayList<Map> grupo = new ArrayList<>();
        Map<Participante,Vector> participante = new HashMap<>();
        for(int i = 0; i < participantes.size()/4; i++){
            for(int j = 0; j < 4; j++){
                participante.put(participantes.get(i+j),new Vector<>(6));
                grupo.add(participante);
            }
            grupos.put("Grupo" + (i+1), grupo);
            grupo.clear();
        }
    }
}
