package co.com.ceiba.adn.infrastructure.error;

import lombok.Getter;

@Getter
public class Error {
	private String excepcion;
    private String mensaje;
    
    public Error(String excepcion, String mensaje) {
        this.excepcion = excepcion;
        this.mensaje = mensaje;
    }

}
