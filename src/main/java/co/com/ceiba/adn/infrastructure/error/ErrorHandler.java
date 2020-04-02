package co.com.ceiba.adn.infrastructure.error;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.ceiba.adn.domain.exception.MaximumLenghtException;
import co.com.ceiba.adn.domain.exception.MinimumLenghtException;
import co.com.ceiba.adn.domain.exception.RangeException;
import co.com.ceiba.adn.domain.exception.RequiredValueException;
import co.com.ceiba.adn.domain.exception.ValidValueException;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
	private static final ConcurrentHashMap<String, Integer> STATUSCODE = new ConcurrentHashMap<>();
	private static final Logger LOG = LoggerFactory.getLogger(ErrorHandler.class);

	public ErrorHandler() {
		STATUSCODE.put(MaximumLenghtException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		STATUSCODE.put(MinimumLenghtException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		STATUSCODE.put(RangeException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		STATUSCODE.put(RequiredValueException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		STATUSCODE.put(ValidValueException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
		ResponseEntity<Error> result;

		String excepcion = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = STATUSCODE.get(excepcion);

		if (codigo != null) {
			Error error = new Error(excepcion, mensaje);
			result = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		} else {
			LOG.error(excepcion, exception);
			Error error = new Error(excepcion, "Error en el sistema, contacte el administrador.");
			result = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;
	}
}
