package modelos;

import java.util.ArrayList;

/**
 * Interfaz que define el comportamiento de un calendario de torneo.
 * Permite la creación y actualización de jornadas según el tipo de torneo (liga, eliminación directa, eliminacion doble).
 */
interface TipoDeCalendario {

    /**
     * Crea el calendario inicial del torneo, generando las jornadas y enfrentamientos correspondientes.
     * @param alj Lista de jornadas donde se agregará la estructura del calendario.
     * @param cantEnfretamientosIgual Cantidad de veces que se enfrentan los mismos participantes
     * @param p Objeto que contiene información sobre la cantidad de participantes y jornadas.
     * @param participantes Lista de participantes del torneo.
     */
    void creacionCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participantes);

    /**
     * Actualiza el calendario después de una jornada completada, agregando nuevos enfrentamientos si es necesario.
     * @param alj Lista de jornadas del torneo.
     * @param cantEnfretamientosIgual Cantidad de veces que se enfrentan los mismos participantes.
     */
    void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual);
}
