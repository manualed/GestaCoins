package co.com.ceiba.adn.application.command;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Generated
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
}
