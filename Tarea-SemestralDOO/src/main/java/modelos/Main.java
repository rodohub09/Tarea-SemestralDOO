package modelos;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        ArrayList<Jornada> j = new ArrayList<>();

        Participantes p = new Participantes();
        p.addParticipante(new Participante("w"));
        p.addParticipante(new Participante("s"));
        p.addParticipante(new Participante("a"));
        p.addParticipante(new Participante("f"));
        Calendario jxp = new Calendario(TipoTorneo.Liga);

        jxp.crearCalendario(TipoTorneo.Liga,2,CantidadParticipantes.Cuatro,p);
        System.out.println(jxp.toString());
        jxp.actualizarCalendario(2,CantidadParticipantes.Cuatro,p);
        System.out.println(j.get(2).partidos.get(0));
    }
}
