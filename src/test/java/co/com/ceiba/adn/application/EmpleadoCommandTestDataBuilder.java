package co.com.ceiba.adn.application;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.adn.application.command.EmpleadoCommand;

public class EmpleadoCommandTestDataBuilder {
	private long idEmpleado;
	private String tipoDocumento;
	private String numeroDocumento;
	private String primerNombre;
	private String primerApellido;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Date fechaCambio;
	private String email;

	public EmpleadoCommandTestDataBuilder() {
		this.idEmpleado = 1;
		this.tipoDocumento = "CC";
		this.numeroDocumento = "34234234423";
		this.primerNombre = "JUAN";
		this.primerApellido = "URZUA";
		this.fechaIngreso = new Calendar.Builder().setDate(2012, 6, 4).build().getTime();
		this.fechaNacimiento = new Calendar.Builder().setDate(1983, 6, 6).build().getTime();
		this.fechaCambio = new Calendar.Builder().setInstant(Instant.now().getEpochSecond()).build().getTime();
		this.email = "manuel.durango@ceiba.com.co";
	}

	public EmpleadoCommandTestDataBuilder conIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
		return this;
	}

	public EmpleadoCommandTestDataBuilder conTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
		return this;
	}

	public EmpleadoCommandTestDataBuilder conNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
		return this;
	}

	public EmpleadoCommandTestDataBuilder conPrimerNombre(String nombre) {
		this.primerNombre = nombre;
		return this;
	}

	public EmpleadoCommandTestDataBuilder conPrimerApellido(String apellido) {
		this.primerApellido = apellido;
		return this;
	}

	public EmpleadoCommandTestDataBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}

	public EmpleadoCommandTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public EmpleadoCommandTestDataBuilder conFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
		return this;
	}

	public EmpleadoCommandTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}
	
	public EmpleadoCommand build() {
		return new EmpleadoCommand(idEmpleado, tipoDocumento, numeroDocumento, primerNombre, primerApellido, fechaIngreso,
				fechaNacimiento, fechaCambio, email);
	}
	
}
