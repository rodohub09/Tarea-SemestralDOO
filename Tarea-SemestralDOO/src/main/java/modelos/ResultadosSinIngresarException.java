package modelos;

/**
 * Excepción que se lanza cuando se intenta avanzar de jornada sin antes ingresar los resultados de los enfrentamientos
 * de la jornada actual.
 */
public class ResultadosSinIngresarException extends RuntimeException {
    /**
     * Crea una instancia de la excepcion {@code ResultadoSinIngresarException}.
     */
    public ResultadosSinIngresarException() {
        super();
    }
}