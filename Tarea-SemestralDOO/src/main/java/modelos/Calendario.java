package modelos;
import vistas.PanelPrincipal;

import java.util.ArrayList;

/**
 *
 */
public class Calendario {
    private ArrayList<Jornada> jornadas;
    private TipoDeCalendario tipoDeCalendario;

    public Calendario(){
        this.jornadas = new ArrayList<>();
    }

    /**
     * @param tt
     * @param cantEnfretamientosIgual
     * @param p
     * @param participantes
     */
    public void setTipoDeCalendario(TipoTorneo tt, int cantEnfretamientosIgual, CantidadParticipantes p,Participantes participantes) {
        if(tt==TipoTorneo.Liga){
            this.tipoDeCalendario = new CalendarioXPuntos();
            tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }else if(tt==TipoTorneo.Eliminacion_Directa){
            this.tipoDeCalendario = new CalendarioElimDirecta();
            tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }
    }

    public void actualizarCalendario(){
        tipoDeCalendario.actualizarCalendario(jornadas, PanelPrincipal.torneo.getCantidadParticipantes().getEnfrentamientosXJornadaElimDirecta());
    }

    public Jornada getJornada(int numJornada) {
        return jornadas.get(numJornada);
    }

    public int getCantJornadas() {
        return jornadas.size();
    }

    public void setJornadas(ArrayList<Jornada> jornadas) {
        this.jornadas = jornadas;
    }
}