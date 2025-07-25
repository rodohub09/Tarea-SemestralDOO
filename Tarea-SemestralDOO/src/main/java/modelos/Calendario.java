package modelos;
import java.util.ArrayList;


/**
 * Clase que gestiona el calendario del torneo, incluyendo la lista de las jornadas
 * y el tipo de calendario a utilizar (liga, eliminación directa o eliminación doble).
 */
public class Calendario {
    private ArrayList<Jornada> jornadas;
    private TipoDeCalendario tipoDeCalendario;

    /**
     * Constructor que inicializa la lista de jornadas vacía.
     */
    public Calendario(){
        this.jornadas = new ArrayList<>();
    }

    /**
     * Define el tipo de calendario en base al tipo de torneo y genera las jornadas correspondientes.
     * @param tt Tipo de torneo (liga, eliminación directa o eliminación doble).
     * @param cantEnfretamientosIgual Cantidad de partidos por enfrentamiento (sólo ida o formato ida-vuelta).
     * @param p Cantidad de participantes.
     * @param participantes Lista de participantes del torneo.
     */
    public void setTipoDeCalendario(TipoTorneo tt, int cantEnfretamientosIgual, CantidadParticipantes p,Participantes participantes) {
        if (tt == TipoTorneo.Liga) {
            this.tipoDeCalendario = new CalendarioXPuntos();
            tipoDeCalendario.creacionCalendario(jornadas, cantEnfretamientosIgual, p, participantes);
        } else if (tt == TipoTorneo.Eliminacion_Directa) {
            this.tipoDeCalendario = new CalendarioElimDirecta();
            tipoDeCalendario.creacionCalendario(jornadas, cantEnfretamientosIgual, p, participantes);
        } else if (tt == TipoTorneo.Doble_Eliminacion) {
            this.tipoDeCalendario = new CalendarioElimDoble();
            tipoDeCalendario.creacionCalendario(jornadas, cantEnfretamientosIgual, p, participantes);
        }
    }

    /**
     * Getter de una jornada.
     * @param numJornada Índice de la jornada deseada.
     * @return La jornada correspondiente.
     */
    public Jornada getJornada(int numJornada) {
        return jornadas.get(numJornada);
    }

    /**
     * Getter de la cantidad total de jornadas que tiene el torneo.
     * @return Número total de jornadas.
     */
    public int getCantJornadas() {
        return jornadas.size();
    }

    /**
     * Llama al metodo homonimo del tipo calendario correspondiente, y asi actualizar el calendario, segun pasan las jornadas
     * @param activos entrega los participantes que siguen en el torneo.
     * */
    public void actualizarCalendario(ArrayList<Participante> activos){
        tipoDeCalendario.actualizarCalendario(jornadas,activos);
    }

    /**
     * Getter de el tipo de calendario en cuestion
     * @return instancia del tipo de calendario.
     */
    public TipoDeCalendario getTipoDeCalendario() {
        return tipoDeCalendario;
    }

    /**
     * Representacion en texto del calendario.
     * @return Cadena con todos los enfrentamientos de la jornada.
     */
    public String toString(){
        String s = "";
        for(int i=0;i<jornadas.size();i++){
            s += "Jornada " + (i+1) + ":\n" + jornadas.get(i) + "\n";
        }
        return s;
    }
}