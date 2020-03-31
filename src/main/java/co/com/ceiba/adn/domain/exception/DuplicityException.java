package co.com.ceiba.adn.domain.exception;

public class DuplicityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicityException(String mensaje) {
        super(mensaje);
    }
}
