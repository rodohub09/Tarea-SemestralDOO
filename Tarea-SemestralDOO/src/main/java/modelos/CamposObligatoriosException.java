package modelos;

/**
 * Crea una excepción que se lanza cuando no se ingresa uno de los campos necesarios para crear un torneo.
 */
public class CamposObligatoriosException extends RuntimeException {
    /**
     * Crea una instancia de {@code CamposObligatoriosException}.
     */
    public CamposObligatoriosException() {
        super();
    }
}
