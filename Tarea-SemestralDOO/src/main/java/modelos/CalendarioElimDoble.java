package modelos;

import java.util.ArrayList;

/**
 * Clase que representa el calendario para un torneo de eliminación doble.
 * Se encarga de crear y actualizar las jornadas del torneo utilizando los brackets
 * definidos por {@link AgrupacionElimDoble}.
 */
public class CalendarioElimDoble implements TipoDeCalendario {
    /**
     * Crea el calendario inicial con enfrentamientos entre los participantes del Upper Bracket.
     * @param alj Lista de jornadas del torneo.
     * @param cantEnfrentamientosJornada Cantidad de enfrentamientos por jornada.
     * @param p Configuración de cantidad de participantes.
     * @param participantes Lista de participantes agrupados según el tipo de torneo.
     */
    @Override
    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfrentamientosJornada, CantidadParticipantes p, Participantes participantes) {
        Jornada jornadaInicial = new Jornada();
        ArrayList<Participante> upperBracket = participantes.participantes;

        for (int i = 0; i < upperBracket.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(upperBracket.get(i), upperBracket.get(upperBracket.size() - i - 1), null);
            jornadaInicial.getEnfrentamientos().add(e);
        }
        alj.add(jornadaInicial);
    }

    /**
     * Actualiza las siguientes jornadas del torneo considerando los ganadores y perdedores de la jornada actual.
     * @param alj Lista de jornadas del torneo.
     * @param cantEnfrentamientosJornada Cantidad de enfrentamientos por jornada.
     */
    public void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfrentamientosJornada, ArrayList<Participante> activos) {
        Jornada nuevaJornada = new Jornada();

        ArrayList<Participante> upperBracket = new ArrayList<>();
        ArrayList<Participante> lowerBracket = new ArrayList<>();

        for (Enfrentamiento e : nuevaJornada.getEnfrentamientos()) {
            Participante ganador = e.getGanador();
            if (ganador != null) {
                upperBracket.add(ganador);
                Participante perdedor = (e.getLocal() == ganador) ? e.getVisita() : e.getLocal();
                lowerBracket.add(perdedor);
            }
        }

        alj.add(nuevaJornada);

        Jornada nuevaJornadaUpper = new Jornada();
        for (int i = 0; i < upperBracket.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(upperBracket.get(i), upperBracket.get(upperBracket.size() - i - 1), null);
            nuevaJornadaUpper.getEnfrentamientos().add(e);
        }

        Jornada nuevaJornadaLower = new Jornada();
        for (int i = 0; i < lowerBracket.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(lowerBracket.get(i), lowerBracket.get(lowerBracket.size() - i - 1), null);
            nuevaJornadaLower.getEnfrentamientos().add(e);
        }
    }
}