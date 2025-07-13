package modelos;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        ArrayList<Jornada> j = new ArrayList<>();

        Participantes p = new Participantes();
        p.addParticipante(new Participante("w","1"));
        p.addParticipante(new Participante("s","2"));
        p.addParticipante(new Participante("a","3"));
        p.addParticipante(new Participante("f","4"));
        CalendarioXPuntos jxp = new CalendarioXPuntos();

        jxp.creacionCalendario(j,2,CantidadParticipantes.Cuatro,p);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fuentes = ge.getAvailableFontFamilyNames();

        for (String f : fuentes) {
            System.out.println(f);
        }
    }
}
