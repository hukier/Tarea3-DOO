package backend.Excepciones;

/**
 * Excepción que se lanza cuando el pago es insuficiente
 * 
 * @author Martin Gonzalez
 */

public class PagoInsuficienteException extends Exception {

    public PagoInsuficienteException() {
        super("Pago insuficiente");
    }
}
