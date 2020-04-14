package co.com.ceiba.adn.domain.model.entity;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
@Generated
@Setter
@Getter
public class Empleado {
	
	private static final String TIPO_DOCUMENTO_OBLIGATORIO = "El tipo documento es obligatorio.";
	private static final String NUMERO_DOCUMENTO_OBLIGATORIO = "El numero de documento es obligatorio.";
	private static final String PRIMER_NOMBRE_OBLIGATORIO = "El primer nombre es obligatorio.";
	private static final String PRIMER_APELLIDO_OBLIGATORIO = "El primer apellido es obligatorio.";
	private static final String FECHA_INGRESO_OBLIGATORIO = "La fecha de ingreso es obligatoria.";	
	private static final String FECHA_NACIMIENTO_OBLIGATORIO = "La fecha de nacimiento es obligatoria.";	
	private static final String FECHA_CAMBIO_OBLIGATORIO = "La fecha del cambio del registro es obligatorio.";	
	private static final String EMAIL_OBLIGATORIO = "El email es obligatorio.";
	
	private static final String DOCUMENTO_DEBE_TENER_MAXIMO = "El documento debe tener maximo %s caracteres.";
	private static final String DOCUMENTO_DEBE_TENER_MINIMO = "El documento debe tener minimo %s caracteres.";
	private static final String NOMBRE_DEBE_TENER_MAXIMO = "El nombre debe tener maximo %s caracteres.";
	private static final String NOMBRE_DEBE_TENER_MINIMO = "El nombre debe tener minimo %s caracteres.";
	private static final String APELLIDO_DEBE_TENER_MAXIMO = "El apellido debe tener maximo %s caracteres.";
	private static final String APELLIDO_DEBE_TENER_MINIMO = "El apellido debe tener minimo %s caracteres.";
	private static final String EMAIL_DEBE_TENER_MAXIMO = "El email debe tener maximo %s caracteres.";
	private static final String EMAIL_DEBE_TENER_MINIMO = "El email debe tener minimo %s caracteres.";
	
	private static final int TAMANO_MAXIMO_DOCUMENTO = 50;
	private static final int TAMANO_MINIMO_DOCUMENTO = 3;
	private static final int TAMANO_MAXIMO_NOMBRE = 50;
	private static final int TAMANO_MINIMO_NOMBRE = 1;
	private static final int TAMANO_MAXIMO_APELLIDO = 50;
	private static final int TAMANO_MINIMO_APELLIDO = 1;
	private static final int TAMANO_MAXIMO_EMAIL = 50;
	private static final int TAMANO_MINIMO_EMAIL = 1;

	private long idEmpleado;
	private String tipoDocumento;
	private String numeroDocumento;
	private String primerNombre;
	private String primerApellido;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Date fechaCambio;
	private String email;
	private List<Transaccion> transacciones;

	public Empleado(long idEmpleado, String tipoDocumento, String numeroDocumento, String primerNombre,
			String primerApellido, Date fechaIngreso, Date fechaNacimiento, Date fechaCambio, String email) {
		
		
		Validador.validarObligatoriedad(tipoDocumento, TIPO_DOCUMENTO_OBLIGATORIO);
		Validador.validarObligatoriedad(numeroDocumento, NUMERO_DOCUMENTO_OBLIGATORIO);
		Validador.validarObligatoriedad(primerNombre, PRIMER_NOMBRE_OBLIGATORIO);
		Validador.validarObligatoriedad(primerApellido, PRIMER_APELLIDO_OBLIGATORIO);
		Validador.validarObligatoriedad(fechaIngreso, FECHA_INGRESO_OBLIGATORIO);
		Validador.validarObligatoriedad(fechaNacimiento, FECHA_NACIMIENTO_OBLIGATORIO);
		//Validador.validarObligatoriedad(new Calendar.Builder().setInstant(Instant.now().getEpochSecond()).build().getTime(), FECHA_CAMBIO_OBLIGATORIO);
		Validador.validarObligatoriedad(fechaCambio, FECHA_CAMBIO_OBLIGATORIO);
		Validador.validarObligatoriedad(email, EMAIL_OBLIGATORIO);
		
		Validador.validarMaxLenght(numeroDocumento, TAMANO_MAXIMO_DOCUMENTO, String.format(DOCUMENTO_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_DOCUMENTO));
		Validador.validarMinLenght(numeroDocumento, TAMANO_MINIMO_DOCUMENTO, String.format(DOCUMENTO_DEBE_TENER_MINIMO, TAMANO_MINIMO_DOCUMENTO));
		Validador.validarMaxLenght(primerNombre, TAMANO_MAXIMO_NOMBRE, String.format(NOMBRE_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_NOMBRE));
		Validador.validarMinLenght(primerNombre, TAMANO_MINIMO_NOMBRE, String.format(NOMBRE_DEBE_TENER_MINIMO, TAMANO_MINIMO_NOMBRE));
		Validador.validarMaxLenght(primerApellido, TAMANO_MAXIMO_APELLIDO, String.format(APELLIDO_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_APELLIDO));
		Validador.validarMinLenght(primerApellido, TAMANO_MINIMO_APELLIDO, String.format(APELLIDO_DEBE_TENER_MINIMO, TAMANO_MINIMO_APELLIDO));
		Validador.validarMaxLenght(email, TAMANO_MAXIMO_EMAIL, String.format(EMAIL_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_EMAIL));
		Validador.validarMinLenght(email, TAMANO_MINIMO_EMAIL, String.format(EMAIL_DEBE_TENER_MINIMO, TAMANO_MINIMO_EMAIL));

		
		this.idEmpleado = idEmpleado;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCambio = new Calendar.Builder().setInstant(Instant.now().getEpochSecond()).build().getTime();
		this.email = email;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaCambio() {
		return new Date(fechaCambio.getTime());
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setBonificaciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
	
	

}
