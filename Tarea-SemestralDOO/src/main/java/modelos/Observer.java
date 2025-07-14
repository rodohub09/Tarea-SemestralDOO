package modelos;

/**
 * Interfaz para participantes que desean ser notificados cuando se registra un resultado en el torneo.
 */
public interface Observer {
    /**
     * Metodo llamado para notificar el registro de un nuevo resultado.
     * @param resultado Enum que contiene una lista de resultados posibles de un enfrentamiento.
     */
    void registrarResultado(Resultados resultado);
}