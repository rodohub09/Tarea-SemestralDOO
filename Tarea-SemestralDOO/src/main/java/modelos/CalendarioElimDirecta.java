package modelos;
import java.util.ArrayList;

/**
 * Implementación del calendario para torneos de eliminación directa.
 * Se encarga de generar las jornadas a partir de los participantes activos proporcionados por la agrupación.
 */
public class CalendarioElimDirecta implements TipoDeCalendario {
    /**
     * Crea las jornadas iniciales de un torneo de eliminación directa.
     * @param alj Lista donde se agregan las jornadas generadas.
     * @param cantEnfretamientosIgual Número de enfrentamientos por jornada (ida o ida-vuelta).
     * @param p Cantidad de participantes.
     * @param participante Participantes registrados en el torneo.
     */
    @Override
    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participante) {
        Jornada jornadaInicial = new Jornada();
        int n = participante.participantes.size();
        for (int i = 0; i < n / 2; i++) {
            Enfrentamiento ida = new Enfrentamiento(participante.participantes.get(i), participante.participantes.get(n - i - 1), null);
            jornadaInicial.getEnfrentamientos().add(ida);
        }
        alj.add(jornadaInicial);
    }

    /**
     * Agrega una nueva jornada con enfrentamientos generados a partir de los participantes activos.
     * @param alj Lista de jornadas donde se agrega la nueva.
     * @param cantEnfretamientosIgual Número de enfrentamientos por ronda (ida o ida y vuelta).
     * @param activos Lista de participantes activos entregados por la agrupación.
     */
    public void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, ArrayList<Participante> activos) {
        Jornada nuevaJornada = new Jornada();
        int n = activos.size();
        for (int i = 0; i < n / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(activos.get(i), activos.get(n - i - 1), null);
            nuevaJornada.getEnfrentamientos().add(e);
        }
        alj.add(nuevaJornada);
    }
}