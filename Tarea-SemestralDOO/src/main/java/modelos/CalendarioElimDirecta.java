package modelos;
import java.util.ArrayList;

public class CalendarioElimDirecta implements TipoDeCalendario{
    public int fecha = 0;
    static public String tipoCalendario = "Eliminacsadion Directa";

    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participante) {
        for(int i=0;i<p.getEnfrentamientosXJornadaElimDirecta()*cantEnfretamientosIgual;i++){
            alj.add(new Jornada(participante,TipoTorneo.Liga));
        }
        for(int i=0;i<p.getEnfrentamientosXJornadaElimDirecta()*cantEnfretamientosIgual;i += cantEnfretamientosIgual){
            if(i==0){
                for(int j=0;j< participante.participantes.size()/2;j++){
                    alj.get(i).enfrentamientos.add(new Enfrentamiento(participante.participantes.get(j), participante.participantes.get(participante.participantes.size() - j - 1),null));
                    if(cantEnfretamientosIgual == 2) {
                        alj.get(i + 1).enfrentamientos.add(new EnfrentamientoVuelta(participante.participantes.get(participante.participantes.size() - j - 1), participante.participantes.get(j), null, alj.get(i).getEnfrentamientos().get(j)));
                    }
                }
            }else{
                for(int j=0;j< (participante.participantes.size()*cantEnfretamientosIgual)/(2*2*i);j++) {
                    alj.get(i).enfrentamientos.add(new Enfrentamiento(alj.get(i - 1).enfrentamientos.get(j).getGanador(), alj.get(i - 1).enfrentamientos.get(((participante.participantes.size()*cantEnfretamientosIgual)/(2*2*i)) - j - 1).getGanador(),null));
                    if(cantEnfretamientosIgual == 2) {
                        alj.get(i+1).enfrentamientos.add(new EnfrentamientoVuelta(alj.get(i - 1).enfrentamientos.get(((participante.participantes.size()*cantEnfretamientosIgual)/(2*2*i)) - j - 1).getGanador(), alj.get(i - 1).enfrentamientos.get(j).getGanador(),null,alj.get(i).getEnfrentamientos().get(j)));
                    }
                }
            }

        }
        this.fecha += cantEnfretamientosIgual;
    }

    public void actualizarCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual) {
        int i = 0;
        while(i < alj.get(fecha).enfrentamientos.size()) {
            alj.get(fecha).getEnfrentamientos().get(i).local = alj.get(fecha - 1).getEnfrentamientos().get(i).getGanador();
            alj.get(fecha).getEnfrentamientos().get(i).visita = alj.get(fecha - 1).getEnfrentamientos().get(alj.get(fecha - 1).enfrentamientos.size() - i - 1).getGanador();
            if (cantEnfretamientosIgual == 2) {
                alj.get(fecha).getEnfrentamientos().get(i).local = alj.get(fecha - 1).getEnfrentamientos().get(alj.get(fecha - 1).enfrentamientos.size() - i - 1).getGanador();
                alj.get(fecha).getEnfrentamientos().get(i).visita = alj.get(fecha - 1).getEnfrentamientos().get(i).getGanador();
            }
            i+= cantEnfretamientosIgual;
        }
        this.fecha += cantEnfretamientosIgual;
    }
}
