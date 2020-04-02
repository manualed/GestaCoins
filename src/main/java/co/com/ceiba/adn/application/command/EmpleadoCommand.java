package co.com.ceiba.adn.application.command;

import java.util.Date;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Generated
@Setter
@Getter
public class EmpleadoCommand {
	private long idEmpleado;
	private String tipoDocumento;
	private String numeroDocumento;
	private String primerNombre;
	private String primerApellido;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Date fechaCambio;
	private String email;

	public EmpleadoCommand(long idEmpleado, String tipoDocumento, String numeroDocumento, String primerNombre,
			String primerApellido, Date fechaIngreso, Date fechaNacimiento, Date fechaCambio, String email) {
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

	public EmpleadoCommand() {

	}
}
