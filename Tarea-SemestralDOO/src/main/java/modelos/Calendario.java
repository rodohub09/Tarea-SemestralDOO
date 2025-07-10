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
        }else if(tt==TipoTorneo.EliminacionDirecta){
            this.tipoDeCalendario = new CalendarioElimDirecta();
            tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }else if(tt==TipoTorneo.FaseGrupos){
            this.tipoDeCalendario = new CalendarioXPuntos();
            tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }
    }

    public void setTipoDeCalendario(TipoDeCalendario tipoDeCalendario) {
        this.tipoDeCalendario = tipoDeCalendario;
    }

    public void crearCalendario(TipoTorneo tt,int cantEnfretamientosIgual, CantidadParticipantes p,Participantes participantes){
        switch (tt){
            case TipoTorneo.Liga -> tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
            case TipoTorneo.EliminacionDirecta -> tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }
    }
}
