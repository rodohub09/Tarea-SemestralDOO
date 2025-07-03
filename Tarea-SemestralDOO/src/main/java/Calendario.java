import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calendario {
    private ArrayList<Jornada> jornadas;
    private TipoDeCalendario tipoDeCalendario;

    public Calendario(TipoTorneo tt, int cantEnfretamientosIgual, CantidadParticipantes p,Participantes participantes){
        this.jornadas = new ArrayList<>();
        if(tt==TipoTorneo.Liguilla){
            this.tipoDeCalendario = new CalendarioXPuntos();
            tipoDeCalendario.crearCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
        }
    }


}
