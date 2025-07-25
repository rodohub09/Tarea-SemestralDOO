package modelos;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que gestiona un enfrentamiento entre dos participantes de un torneo.
 * Permite registrar al ganador, empates y acceder a detalles del partido.
 */
public class Enfrentamiento {
    public Participante local;
    public Participante visita;
    private Participante ganador = null;
    private boolean esEmpate = false;
    private Date fecha;

    /**
     * Constructor de un enfrentamiento.
     * @param local Participante local.
     * @param visita Participante visitante.
     * @param fecha Fecha del enfrentamiento.
     */
    public Enfrentamiento(Participante local, Participante visita, Date fecha) {
        this.local = local;
        this.visita = visita;
        this.fecha = fecha;
    }

    /**
     * Establece al ganador del enfrentamiento y registra los resultados en ambos participantes.
     * @param ganador Participante que ganó el enfrentamiento.
     */
    public void setGanador(Participante ganador) {
        this.ganador = ganador;
        this.esEmpate = false;

        local.registrarResultado((local == ganador) ? Resultados.Victoria : Resultados.Derrota);
        visita.registrarResultado((visita == ganador) ? Resultados.Victoria : Resultados.Derrota);
    }

    /**
     * Declara el enfrentamiento como empate y actualiza ambos participantes.
     */
    public void setEmpate() {
        this.ganador = null;
        this.esEmpate = true;

        local.registrarResultado(Resultados.Empate);
        visita.registrarResultado(Resultados.Empate);
    }


    /**
     * Indica si el enfrentamiento terminó en empate.
     * @return true si fue empate, false si no.
     */
    public boolean isEmpate() {
        return esEmpate;
    }

    /**
     * Getter del ganador del enfrentamiento.
     * @return Participante ganador o null si fue empate.
     */
    public Participante getGanador() {
        return ganador;
    }

    /**
     * Devuelve el perdedor del enfrentamiento.
     * @return perdedor del enfrentamiento.
     * */
    public Participante getPerdedor() {
        return ganador == local ? visita : local;
    }

    /**
     * Devuelve la fecha del enfrentamiento en formato "dd/MM".
     * @return Fecha del enfrentamiento o null si no hay fecha asignada.
     */
    public String getFecha() {
        if(fecha != null) {
            SimpleDateFormat simple = new SimpleDateFormat("dd/MM");
            return simple.format(fecha);
        }
        else
            return null;
    }

    /**
     * Getter del participante local.
     * @return Participante local.
     */
    public Participante getLocal(){
        return local;
    }

    /**
     * Getter del participante visitante.
     * @return Participante visitante.
     */
    public Participante getVisita(){
        return visita;
    }

    /**
     * Getter del nombre del participante local.
     * @return Nombre del participante local.
     */
    public String getStringLocal() {
        return local.getNombre();
    }

    /**
     * Getter del nombre del participante visitante.
     * @return Nombre del participante visitante.
     */
    public String getStringVisita() {
        return visita.getNombre();
    }

    /**
     * Representación en texto del enfrentamiento.
     * @return Cadena con formato: "Partido: [local] vs [visita]".
     */
    @Override
    public String toString() {
        String s = "";
        try{
            s += "Partido: " + local.getNombre() + " vs " + visita.getNombre();
        }catch (NullPointerException e){
            s += "Partido por definir";
        }

        return s;
    }
}