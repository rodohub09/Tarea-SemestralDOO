package modelos;
import java.util.ArrayList;

public class Calendario {
    private ArrayList<Jornada> jornadas;
    private TipoDeCalendario tipoDeCalendario;

    public Calendario(TipoTorneo tt, int cantEnfretamientosIgual, CantidadParticipantes p,Participantes participantes){
        this.jornadas = new ArrayList<>();
        if(tt==TipoTorneo.Liga){
            this.tipoDeCalendario = new CalendarioXPuntos();
            tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }else if(tt==TipoTorneo.Eliminacion_Directa){
            this.tipoDeCalendario = new CalendarioElimDirecta();
            tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }
    }

    public void setTipoDeCalendario(TipoDeCalendario tipoDeCalendario) {
        this.tipoDeCalendario = tipoDeCalendario;
    }

    public void crearCalendario(TipoTorneo tt,int cantEnfretamientosIgual, CantidadParticipantes p,Participantes participantes){
        switch (tt){
            case TipoTorneo.Liga, TipoTorneo.Eliminacion_Directa -> tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }
    }
    public Jornada getJornada(int numJornada) {
        return jornadas.get(numJornada);
    }

    public int getCantJornadas() {
        return jornadas.size();
    }
}
