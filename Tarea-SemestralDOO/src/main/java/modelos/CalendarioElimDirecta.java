package modelos;
import java.util.ArrayList;

public class CalendarioElimDirecta implements TipoDeCalendario{
    public int fecha = 0;

    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participante) {
        for(int i=0;i<p.getEnfrentamientosXJornadaElimDirecta()*cantEnfretamientosIgual;i++){
            alj.add(new Jornada(participante,TipoTorneo.Liga));
        }
        for(int i=0;i<p.getEnfrentamientosXJornadaElimDirecta()*cantEnfretamientosIgual;i += cantEnfretamientosIgual){
            if(i==0){
                for(int j=0;j< participante.participantes.size()/2;j++){
                    alj.get(i).partidos.add(new Enfrentamiento(participante.participantes.get(j), participante.participantes.get(participante.participantes.size() - j - 1),null));
                    if(cantEnfretamientosIgual == 2) {
                        alj.get(i + 1).partidos.add(new EnfrentamientoVuelta(participante.participantes.get(participante.participantes.size() - j - 1), participante.participantes.get(j), null, alj.get(i).getPartidos().get(j)));
                    }
                }
            }else{
                for(int j=0;j< (participante.participantes.size()*cantEnfretamientosIgual)/(2*2*i);j++) {
                    alj.get(i).partidos.add(new Enfrentamiento(alj.get(i - 1).partidos.get(j).getGanador(), alj.get(i - 1).partidos.get(((participante.participantes.size()*cantEnfretamientosIgual)/(2*2*i)) - j - 1).getGanador(),null));
                    if(cantEnfretamientosIgual == 2) {
                        alj.get(i+1).partidos.add(new EnfrentamientoVuelta(alj.get(i - 1).partidos.get(((participante.participantes.size()*cantEnfretamientosIgual)/(2*2*i)) - j - 1).getGanador(), alj.get(i - 1).partidos.get(j).getGanador(),null,alj.get(i).getPartidos().get(j)));
                    }
                }
            }

        }
        this.fecha += cantEnfretamientosIgual;
    }

    public void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual) {
        int i = 0;
        while(i < alj.get(fecha).partidos.size()) {
            alj.get(fecha).getPartidos().get(i).local = alj.get(fecha - 1).getPartidos().get(i).getGanador();
            alj.get(fecha).getPartidos().get(i).visita = alj.get(fecha - 1).getPartidos().get(alj.get(fecha - 1).partidos.size() - i - 1).getGanador();
            if (cantEnfretamientosIgual == 2) {
                alj.get(fecha).getPartidos().get(i).local = alj.get(fecha - 1).getPartidos().get(alj.get(fecha - 1).partidos.size() - i - 1).getGanador();
                alj.get(fecha).getPartidos().get(i).visita = alj.get(fecha - 1).getPartidos().get(i).getGanador();
            }
            i+= cantEnfretamientosIgual;
        }
        this.fecha += cantEnfretamientosIgual;
    }
}
