package co.com.ceiba.adn.infrastructure.error;

public class Error {
	private String excepcion;
    private String mensaje;
    
    public Error(String excepcion, String mensaje) {
        this.excepcion = excepcion;
        this.mensaje = mensaje;
    }

    public String getNombreExcepcion() {
        return excepcion;
    }

    public String getMensaje() {
        return mensaje;
    }
}
