package modelos;

/**
 * Excepción que se lanza cuando se quiere crear un torneo y la cantidad de participantes ingresados
 * no coincide con la cantidad de participantes seleccionada.
 */
public class CantidadInscritosInvalidaException extends RuntimeException {
    /**
     * Crea una instancia de la excepción {@code CantidadInscritosInvalidaException}.
     */
    public CantidadInscritosInvalidaException() {
        super();
    }
}
