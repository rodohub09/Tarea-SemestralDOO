package modelos;
import java.util.ArrayList;

public class Calendario {
    private ArrayList<Jornada> jornadas;
    private TipoDeCalendario tipoDeCalendario;

    public Calendario(TipoTorneo tt){
        this.jornadas = new ArrayList<>();
        if(tt==TipoTorneo.Liga){
            this.tipoDeCalendario = new CalendarioXPuntos();
        }else if(tt==TipoTorneo.EliminacionDirecta){
            this.tipoDeCalendario = new CalendarioElimDirecta();
        }else if(tt==TipoTorneo.FaseGrupos){
            this.tipoDeCalendario = new CalendarioXPuntos();
        }
    }

    public void setTipoDeCalendario(TipoTorneo tt) {
        if(tt==TipoTorneo.Liga){
            this.tipoDeCalendario = new CalendarioXPuntos();
        }else if(tt==TipoTorneo.EliminacionDirecta){
            this.tipoDeCalendario = new CalendarioElimDirecta();
        }else if(tt==TipoTorneo.FaseGrupos){
            this.tipoDeCalendario = new CalendarioXPuntos();
        }
    }

    public void crearCalendario(TipoTorneo tt, int cantEnfretamientosIgual, CantidadParticipantes p,Participantes participantes){
        switch (tt){
            case TipoTorneo.Liga -> tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
            case TipoTorneo.EliminacionDirecta -> tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual, p, participantes);
            default -> throw new IllegalStateException("Unexpected value: " + this.tipoDeCalendario);
        }
    }

    public void actualizarCalendario(int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participante){
        tipoDeCalendario.creacionCalendario(jornadas,cantEnfretamientosIgual,p,participante);
    }

    public String toString(){
        String s = "";
        for(int i=0;i< jornadas.size();i++){
            s += ("Jornada " + (i+1) + ":\n" + jornadas.get(i).toString() + "\n\n");
        }
        return s;
    }

    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }

    public TipoDeCalendario getTipoDeCalendario() {
        return tipoDeCalendario;
    }
}
