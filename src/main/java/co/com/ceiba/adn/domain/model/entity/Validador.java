package co.com.ceiba.adn.domain.model.entity;

import co.com.ceiba.adn.domain.exception.LenghtValueException;
import co.com.ceiba.adn.domain.exception.MaximumLenghtException;
import co.com.ceiba.adn.domain.exception.MinimumLenghtException;
import co.com.ceiba.adn.domain.exception.RangeException;
import co.com.ceiba.adn.domain.exception.RequiredValueException;
import co.com.ceiba.adn.domain.exception.ValidValueException;

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

	public static void validarValorValido(Long valor, Long valorPermitido, String mensaje) {
		if (valor < valorPermitido) {
			throw new ValidValueException(mensaje);
		}
	}

	public static void validarValorValido(int valor, int valorPermitido, String mensaje) {
		if (valor < valorPermitido) {
			throw new ValidValueException(mensaje);
		}
	}

	public static void validarRangoValido(long valor, long valorPermitido, String mensaje) {
		if (valor < valorPermitido) {
			throw new RangeException(mensaje);
		}
	}

	public static void validarRangoValido(long valor, long minimo, long maximo, String mensaje) {
		if (valor < minimo || valor > maximo) {
			throw new RangeException(mensaje);
		}
	}

	public static void validarRangoNoValido(long valor, long valorNoPermitido, String mensaje) {
		if (valor == valorNoPermitido) {
			throw new RangeException(mensaje);
		}
	}
	
	public static void validarMaxLenght(String size, int maxLenght, String mensaje) {
        if(size.length() > maxLenght) {
            throw new MaximumLenghtException(mensaje);
        }
    }
	
	public static void validarMinLenght(String value, int minLenght, String mensaje) {
        if(value.length() <= minLenght) {
            throw new MinimumLenghtException(mensaje);
        }
    }
}
