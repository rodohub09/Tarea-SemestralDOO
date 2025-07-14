package modelos;

import java.util.ArrayList;

/**
 * Clase que representa el calendario de un torneo de tipo liga, donde cada participante juega contra todos.
 * Genera las jornadas y enfrentamientos en función del número de participantes y la cantidad de partidos.
 */
public class CalendarioXPuntos implements TipoDeCalendario {

    /** Tipo de calendario que representa esta clase. */
    public static String tipoCalendario = "Liga";

    /**
     * Crea el calendario completo del torneo tipo liga, incluyendo rondas de ida y, si corresponde, de vuelta.
     *
     * @param alj Lista donde se agregarán las jornadas generadas.
     * @param cantEnfretamientosIgual Número de enfrentamientos por par (1 = ida, 2 = ida y vuelta).
     * @param p Objeto que contiene la configuración de cantidad de participantes y jornadas.
     * @param participantes Lista de participantes del torneo, con su agrupación actual.
     */
    @Override
    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participantes) {
        ArrayList<Participante> clasificados = participantes.getAgrupacionParticipantes().devolverAgrupacion();

        for (int ronda = 0; ronda < p.getJornadasLiga(); ronda++) {
            Jornada jornada = new Jornada(participantes);
            for (int i = 0; i < p.getEnfrentamientosXJornadaLiga(); i++) {
                int p1 = (ronda + i) % (p.getNumParticipantes() - 1);
                int p2 = (p.getNumParticipantes() - 1 - i + ronda) % (p.getNumParticipantes() - 1);

                if (i == 0)
                    p2 = p.getNumParticipantes() - 1;
                jornada.enfrentamientos.add(new Enfrentamiento(
                        clasificados.get(p1),
                        clasificados.get(p2),
                        null
                ));
            }
            alj.add(jornada);
        }

        if (cantEnfretamientosIgual == 2) {
            for (int i = 0; i < alj.size(); i++) {
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

    public void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, ArrayList<Participante> activos) {

    }
}