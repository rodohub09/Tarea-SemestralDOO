import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calendario {
    private ArrayList<Jornada> jornadas;
    private TipoDeCalendario tipoDeCalendario;

    public Calendario(TipoTorneo tt, int cantEnfretamientosIgual, CantidadParticipantes p,Participantes participantes){
        this.jornadas = new ArrayList<>();
        if(tt==TipoTorneo.Liguilla){
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


}
