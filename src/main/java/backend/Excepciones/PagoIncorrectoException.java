package backend.Excepciones;

/**
 * Excepción que se lanza cuando el pago es incorrecto
 * 
 * @author Martin Gonzalez
 */

public class PagoIncorrectoException extends Exception {

    public PagoIncorrectoException() {
        super("Pago incorrecto");
    }

}
