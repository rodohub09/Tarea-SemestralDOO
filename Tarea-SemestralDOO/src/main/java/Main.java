import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String args[]){
        ArrayList<Jornada> j = new ArrayList<>();
        for(int i=0;i<3;i++){
            j.add(new Jornada());
        }
        Participantes p = new Participantes();
        p.addParticipante(new Participante("w",1));
        p.addParticipante(new Participante("s",2));
        p.addParticipante(new Participante("a",3));
        p.addParticipante(new Participante("f",4));
        JornadaaXPuntos jxp = new JornadaaXPuntos();

        jxp.crearCalendario(j,2,CantidadParticipantes.Cuatro,p);
    }
}
