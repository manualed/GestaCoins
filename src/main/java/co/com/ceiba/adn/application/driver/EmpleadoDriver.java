package co.com.ceiba.adn.application.driver;

import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.application.factory.EmpleadoFactory;
import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.service.EmpleadoService;

@Component
public class EmpleadoDriver {
	private final EmpleadoService empleadoService;
	private final EmpleadoFactory empleadoFactory;

	public EmpleadoDriver(EmpleadoService empleadoService, EmpleadoFactory empleadoFactory) {
		this.empleadoService = empleadoService;
		this.empleadoFactory = empleadoFactory;
	}

	public void insertarEmpleado(EmpleadoCommand empleadoCommand) {
		Empleado empleado = this.empleadoFactory.crearEmpleado(empleadoCommand);
		this.empleadoService.insertarEmpleado(empleado);
	}
	
	public List<Empleado> listar(){
		return this.empleadoService.listar();
	}
	
	public void eliminar(long id) {
		this.empleadoService.eliminar(id);
	}
	
	public Empleado obtenerEmpleado(long id) {
		return this.empleadoService.obtenerEmpleado(id);
	}
	
	public void update(EmpleadoCommand empleadoCommand) {
		Empleado empleado = this.empleadoFactory.crearEmpleado(empleadoCommand);
		this.empleadoService.updateEmpleado(empleado);
	}

}
