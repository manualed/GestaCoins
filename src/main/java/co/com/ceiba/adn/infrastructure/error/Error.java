package co.com.ceiba.adn.infrastructure.error;

import lombok.Generated;
import lombok.Getter;
@Generated
@Getter
public class Error {
	private String excepcion;
    private String mensaje;
    
    public Error(String excepcion, String mensaje) {
        this.excepcion = excepcion;
        this.mensaje = mensaje;
    }

}
