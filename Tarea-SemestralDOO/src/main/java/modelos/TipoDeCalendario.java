package modelos;
import java.util.ArrayList;

interface TipoDeCalendario {
    void creacionCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participantes);
    void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual);
}
