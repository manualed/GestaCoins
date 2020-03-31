package co.com.ceiba.adn.domain.model.entity;

import java.util.Date;
import java.util.List;

public class Empleado {
	
	private static final String TIPO_DOCUMENTO_OBLIGATORIO = "El tipo documento es obligatorio.";
	private static final String NUMERO_DOCUMENTO_OBLIGATORIO = "El numero de documento es obligatorio.";
	private static final String PRIMER_NOMBRE_OBLIGATORIO = "El primer nombre es obligatorio.";
	private static final String PRIMER_APELLIDO_OBLIGATORIO = "El primer apellido es obligatorio.";
	private static final String FECHA_INGRESO_OBLIGATORIO = "La fecha de ingreso es obligatoria.";	
	private static final String FECHA_NACIMIENTO_OBLIGATORIO = "La fecha de nacimiento es obligatoria.";	
	private static final String FECHA_CAMBIO_OBLIGATORIO = "La fecha del cambio del registro es obligatorio.";	
	private static final String EMAIL_OBLIGATORIO = "El email es obligatorio.";
	
	

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
		Validador.validarObligatoriedad(fechaCambio, FECHA_CAMBIO_OBLIGATORIO);
		Validador.validarObligatoriedad(email, EMAIL_OBLIGATORIO);
		
		this.idEmpleado = idEmpleado;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCambio = fechaCambio;
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
		return fechaCambio;
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
