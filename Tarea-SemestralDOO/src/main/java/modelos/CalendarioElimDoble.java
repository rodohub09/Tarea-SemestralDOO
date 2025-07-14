package modelos;

import java.util.ArrayList;

/**
 * Clase que representa el calendario para un torneo de eliminación doble.
 * Se encarga de crear y actualizar las jornadas del torneo utilizando los brackets
 * definidos por {@link AgrupacionElimDoble}.
 */
public class CalendarioElimDoble implements TipoDeCalendario {
    private int fecha = 0;

    /**
     * Crea el calendario inicial con enfrentamientos entre los participantes del Upper Bracket.
     * @param alj Lista de jornadas del torneo.
     * @param cantEnfrentamientosIgual Cantidad de enfrentamientos por jornada.
     * @param p Configuración de cantidad de participantes.
     * @param participantes Lista de participantes agrupados según el tipo de torneo.
     */
    @Override
    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfrentamientosIgual, CantidadParticipantes p, Participantes participantes) {
        ArrayList<Participante> ganadores = participantes.getAgrupacionParticipantes().devolverAgrupacion();

        alj.add(new Jornada(participantes));

        for (int i = 0; i < ganadores.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(ganadores.get(i), ganadores.get(ganadores.size() - i - 1), null);
            alj.get(fecha).getEnfrentamientos().add(e);

            if (cantEnfrentamientosIgual == 2) {
                alj.add(new Jornada(participantes));
                alj.get(fecha + 1).getEnfrentamientos().add(
                        new EnfrentamientoVuelta(e.getVisita(), e.getLocal(), null, e)
                );
            }
        }
        fecha += cantEnfrentamientosIgual;
    }

    /**
     * Actualiza las siguientes jornadas del torneo considerando los ganadores y perdedores de la jornada actual.
     * @param alj Lista de jornadas del torneo.
     * @param cantEnfrentamientosIgual Cantidad de enfrentamientos por jornada.
     */
    public void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfrentamientosIgual,ArrayList<Participante> activos) {
        fecha += cantEnfrentamientosIgual;

        ArrayList<Participante> ganadores = new ArrayList<>();
        ArrayList<Participante> perdedores = new ArrayList<>();

        for (Enfrentamiento e : alj.get(fecha - cantEnfrentamientosIgual).getEnfrentamientos()) {
            Participante ganador = e.getGanador();
            if (ganador != null) {
                ganadores.add(ganador);
                Participante perdedor = (e.getLocal() == ganador) ? e.getVisita() : e.getLocal();
                perdedores.add(perdedor);
            }
        }

        Jornada nuevaJornadaGanadores = new Jornada(null);
        for (int i = 0; i < ganadores.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(ganadores.get(i), ganadores.get(ganadores.size() - i - 1), null);
            nuevaJornadaGanadores.getEnfrentamientos().add(e);

            if (cantEnfrentamientosIgual == 2) {
                Jornada vuelta = new Jornada(null);
                vuelta.getEnfrentamientos().add(
                        new EnfrentamientoVuelta(e.getVisita(), e.getLocal(), null, e)
                );
                alj.add(vuelta);
            }
        }
        alj.add(nuevaJornadaGanadores);

        Jornada nuevaJornadaPerdedores = new Jornada(null);
        for (int i = 0; i < perdedores.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(perdedores.get(i), perdedores.get(perdedores.size() - i - 1), null);
            nuevaJornadaPerdedores.getEnfrentamientos().add(e);

            if (cantEnfrentamientosIgual == 2) {
                Jornada vuelta = new Jornada(null);
                vuelta.getEnfrentamientos().add(
                        new EnfrentamientoVuelta(e.getVisita(), e.getLocal(), null, e)
                );
                alj.add(vuelta);
            }
        }
        alj.add(nuevaJornadaPerdedores);
    }
}