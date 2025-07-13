package modelos;
import java.util.ArrayList;

public class CalendarioXPuntos implements TipoDeCalendario{

    static public String tipoCalendario = "Liga";

    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participantes){
        crearCalendario(alj,  cantEnfretamientosIgual,  p,  participantes);
    }

    public void crearCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participantes) {
        for (int ronda = 0; ronda < p.getJornadasLiga(); ronda++) {
            Jornada jornada = new Jornada(participantes);
            for (int i = 0; i < p.getEnfrentamientosXJornadaLiga(); i++) {
                int p1 = (ronda + i) % (p.getNumParticipantes()- 1);
                int p2 = (p.getNumParticipantes() - 1 - i + ronda) % (p.getNumParticipantes() - 1);

                if (i == 0) p2 = p.getNumParticipantes() - 1;
                jornada.enfrentamientos.add(new Enfrentamiento(
                        participantes.getParticipante(p1),
                        participantes.getParticipante(p2),
                        null
                ));
            }
            alj.add(jornada);
        }

        if (cantEnfretamientosIgual == 2) {
            int tamañoOriginal = alj.size();
            for (int i = 0; i < tamañoOriginal; i++) {
                Jornada original = alj.get(i);
                Jornada vuelta = new Jornada(participantes);
                for (Enfrentamiento e : original.enfrentamientos) {
                    vuelta.enfrentamientos.add(new Enfrentamiento(
                            e.getVisita(),
                            e.getLocal(),
                            null
                    ));
                }
                alj.add(vuelta);
            }
        }

    }
}
