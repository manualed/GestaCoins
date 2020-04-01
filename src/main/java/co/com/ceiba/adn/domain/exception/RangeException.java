package co.com.ceiba.adn.domain.exception;

public class RangeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RangeException(String message) {
        super(message);
    }
}
