package co.com.ceiba.adn.domain.exception;

public class RequiredValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public RequiredValueException(String message) {
        super(message);
    }
}
