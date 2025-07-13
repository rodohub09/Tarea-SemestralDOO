package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalendarioElimDoble implements TipoDeCalendario {
    private int fecha = 0;
    private Map<Integer, ArrayList<Participante>> rondasPerdedores = new HashMap<>();
    private int rondaPerdedores = 0;
    private int rondaGanadores = 0;

    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfrentamientosIgual, CantidadParticipantes p, Participantes participantes) {
        int n = p.getNumParticipantes();
        int totalJornadas = (2 * n - 1) * cantEnfrentamientosIgual;

        for (int i = 0; i < totalJornadas; i++) {
            alj.add(new Jornada(participantes));
        }

        for (int i = 0; i < participantes.participantes.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(
                    participantes.participantes.get(i),
                    participantes.participantes.get(participantes.participantes.size() - i - 1),
                    null
            );
            alj.get(fecha).enfrentamientos.add(e);
            if (cantEnfrentamientosIgual == 2) {
                alj.get(fecha + 1).enfrentamientos.add(new EnfrentamientoVuelta(e.getVisita(), e.getLocal(), null, e));
            }
        }
        fecha += cantEnfrentamientosIgual;
    }

    public void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfrentamientosIgual) {
        int sigFecha = fecha + cantEnfrentamientosIgual;

        Jornada rondaActual = alj.get(fecha);
        Jornada nuevaJornada = alj.get(sigFecha);

        ArrayList<Participante> ganadores = new ArrayList<>();
        ArrayList<Participante> perdedores = new ArrayList<>();

        for (Enfrentamiento e : rondaActual.getEnfrentamientos()) {
            Participante ganador = e.getGanador();
            Participante perdedor = (e.getLocal() == ganador) ? e.getVisita() : e.getLocal();

            ganadores.add(ganador);
            perdedores.add(perdedor);
        }

        for (int i = 0; i < ganadores.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(ganadores.get(i), ganadores.get(ganadores.size() - i - 1), null);
            nuevaJornada.getEnfrentamientos().add(e);
            if (cantEnfrentamientosIgual == 2) {
                alj.get(sigFecha + 1).getEnfrentamientos().add(new EnfrentamientoVuelta(e.getVisita(), e.getLocal(), null, e));
            }
        }
        rondaGanadores++;
        fecha += cantEnfrentamientosIgual;

        rondasPerdedores.putIfAbsent(rondaPerdedores, new ArrayList<>());
        rondasPerdedores.get(rondaPerdedores).addAll(perdedores);

        ArrayList<Participante> perdedoresLowerBracket = rondasPerdedores.get(rondaPerdedores);
        if (perdedoresLowerBracket.size() >= 2) {
            int fechaPerdedores = fecha + cantEnfrentamientosIgual;
            Jornada jornadaPerdedores = alj.get(fechaPerdedores);

            for (int i = 0; i < perdedoresLowerBracket.size() / 2; i++) {
                Enfrentamiento e = new Enfrentamiento(perdedoresLowerBracket.get(i), perdedoresLowerBracket.get(perdedoresLowerBracket.size() - i - 1), null);
                jornadaPerdedores.getEnfrentamientos().add(e);

                if (cantEnfrentamientosIgual == 2) {
                    alj.get(fechaPerdedores + 1).getEnfrentamientos().add(new EnfrentamientoVuelta(e.getVisita(), e.getLocal(), null, e));
                }
            }
            rondasPerdedores.remove(rondaPerdedores);
            rondaPerdedores++;
        }
    }
}