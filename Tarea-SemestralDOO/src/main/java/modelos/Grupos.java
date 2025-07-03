import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Grupos implements AgrupacionParticipantes{
    private Map<String,Map> grupos;

    public Grupos(){
        this.grupos = new HashMap<>();
    }

    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        grupos.clear();
        for(int i = 0; i < participantes.size()/4; i++){
            Map<Participante,Vector> grupo = new HashMap<>();
            for(int j = 0; j < 4; j++){
                grupo.put(participantes.get(i*4+j),new Vector<>(6));;
            }
            grupos.put("Grupo" + (i+1), grupo);
        }
    }

    @Override
    public String toString() {
        return grupos.toString();
    }
}
