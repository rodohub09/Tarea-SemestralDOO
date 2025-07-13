package modelos;

import java.util.ArrayList;

public class AgrupacionElimDoble implements AgrupacionParticipantes {
    private ArrayList<Participante> ganadores;
    private ArrayList<Participante> perdedores;

    public AgrupacionElimDoble() {
        this.ganadores = new ArrayList<>();
        this.perdedores = new ArrayList<>();
    }

    @Override
    public void organizarParticipantes(ArrayList<Participante> participantes) {
        ganadores.clear();
        perdedores.clear();
        ganadores.addAll(participantes);
    }

    public void actualizarUpperBracket(ArrayList<Enfrentamiento> enfrentamientos) {
        ArrayList<Participante> nuevosGanadores = new ArrayList<>();
        for (Enfrentamiento e : enfrentamientos) {
            Participante ganador = e.getGanador();
            if (ganador != null) {
                nuevosGanadores.add(ganador);
                Participante perdedor = e.getLocal() == ganador ? e.getVisita() : e.getLocal();
                perdedores.add(perdedor);
            }
        }
        ganadores = nuevosGanadores;
    }

    public void actualizarLowerBracket(ArrayList<Enfrentamiento> enfrentamientos) {
        ArrayList<Participante> nuevosPerdedores = new ArrayList<>();
        for (Enfrentamiento e : enfrentamientos) {
            Participante ganador = e.getGanador();
            if (ganador != null)
                nuevosPerdedores.add(ganador);
        }
        perdedores = nuevosPerdedores;
    }

    @Override
    public ArrayList<Participante> devolverAgrupacion() {
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.addAll(ganadores);
        participantes.addAll(perdedores);
        return participantes;
    }

    public ArrayList<Participante> getGanadores() {
        return ganadores;
    }

    public ArrayList<Participante> getPerdedores() {
        return perdedores;
    }
}