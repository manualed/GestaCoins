package co.com.ceiba.adn.domain.model.entity;

import co.com.ceiba.adn.domain.exception.LenghtValueException;
import co.com.ceiba.adn.domain.exception.RequiredValueException;

public class Validador {
	private Validador() {

	}

	public static void validarObligatoriedad(Object valor, String mensaje) {
		if (valor == null) {
			throw new RequiredValueException(mensaje);
		}
	}

	public static void validarLongitud(String valor, int longitud, String mensaje) {
		if (valor.length() < longitud) {
			throw new LenghtValueException(mensaje);
		}
	}
}
