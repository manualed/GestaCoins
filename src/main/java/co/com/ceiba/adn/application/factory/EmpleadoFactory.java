package co.com.ceiba.adn.application.factory;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.domain.model.Empleado;

@Component
public class EmpleadoFactory {
	public Empleado crearEmpleado(EmpleadoCommand empleadoCommand) {
		return new Empleado(
				empleadoCommand.getIdEmpleado(), 
				empleadoCommand.getTipoDocumento(), 
				empleadoCommand.getNumeroDocumento(), 
				empleadoCommand.getPrimerNombre(),
				empleadoCommand.getPrimerApellido(),
				empleadoCommand.getFechaIngreso(),
				empleadoCommand.getFechaNacimiento(),
				empleadoCommand.getFechaCambio(),
				empleadoCommand.getEmail());
	}
}
