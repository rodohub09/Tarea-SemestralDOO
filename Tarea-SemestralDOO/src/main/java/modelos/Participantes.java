package modelos;
import java.util.ArrayList;

/**
 * Clase que gestiona una lista de participantes y su agrupación según el tipo de torneo.
 */
public class Participantes {
    private AgrupacionParticipantes agrupacionParticipantes;
    public ArrayList<Participante> participantes;

    /**
     * Constructor que inicializa la lista de participantes vacía.
     */
    public Participantes(){
        this.participantes = new ArrayList<>();
    }

    /**
     * Asigna la agrupación de participantes según el tipo de torneo.
     * @param tipoTorneo Tipo de torneo (Liga, eliminación directa o eliminación doble).
     */
    public void setAgrupacionParticipantes(TipoTorneo tipoTorneo){
        switch (tipoTorneo){
            case Liga -> agrupacionParticipantes = new AgrupacionLiga();
            case Eliminacion_Directa -> agrupacionParticipantes = new AgrupacionElimDirecta();
            case Doble_Eliminacion -> agrupacionParticipantes = new AgrupacionElimDoble();
        }
    }

    /**
     * Agrupa a los participantes mediante un strategy definido por el tipo de torneo.
     */
    public void agrupar(){
        agrupacionParticipantes.organizarParticipantes(participantes);
    }

    /**
     * Devuelve la agrupación actual de participantes.
     * @return Lista de participantes organizada según el tipo de torneo.
     */
    public ArrayList<Participante> devolverAgrupacion(){
        return agrupacionParticipantes.devolverAgrupacion();
    }

    /**
     * Agrega un participante a la lista general.
     * @param participante Participante a agregar.
     */
    public void addParticipante(Participante participante){
        participantes.add(participante);
    }

    /**
     * Devuelve la lista completa de participantes.
     * @return Lista de participantes.
     */
    public ArrayList<Participante> getArrayParticipante() {
        return participantes;
    }

    /**
     * Obtiene un participante según su índice.
     * @param i Índice del participante.
     * @return Participante correspondiente al índice.
     */
    public Participante getParticipante(int i){
        return participantes.get(i);
    }

    /**
     * Getter de la agrupación de participantes.
     * @return Agrupación de participantes.
     */
    public AgrupacionParticipantes getAgrupacionParticipantes() {
        return agrupacionParticipantes;
    }

}