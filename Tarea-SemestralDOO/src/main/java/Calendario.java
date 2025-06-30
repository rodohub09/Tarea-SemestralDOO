import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calendario {
    ArrayList<Jornada> jornada;

    public Calendario(int cantEnfretamientosIgual,CantidadParticipantes p){
        int[][] matrizEnf = new int[p.getNumParticipantes()][p.getNumParticipantes()];
        for(int i=0;i<p.getNumParticipantes();i++){
            for(int j=0;j<p.getNumParticipantes();j++){
                matrizEnf[i][j] = 0;
            }
        }

    }


}
