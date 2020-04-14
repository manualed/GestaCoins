package co.com.ceiba.adn.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.application.driver.EmpleadoDriver;
import co.com.ceiba.adn.domain.model.entity.Empleado;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/coins")
public class EmpleadoController {
	
	private final EmpleadoDriver empleadoDriver;
	
	public EmpleadoController(EmpleadoDriver empleadoDriver) {
		this.empleadoDriver = empleadoDriver;
	}
	
	
	@PostMapping(value = "/empleado")
	public void crearEmpleado(@RequestBody EmpleadoCommand empleadoCommand) {
		this.empleadoDriver.insertarEmpleado(empleadoCommand);
	}
	
	@GetMapping(value = "/empleados")
	public List<Empleado> listar() {
		return this.empleadoDriver.listar();
	}
	

	@DeleteMapping(value = "/empleados/{id}")
	public void eliminar(@PathVariable long id) {
		this.empleadoDriver.eliminar(id);
	}
	
	@GetMapping("/empleado/{id}")
	public Empleado obtenerEmpleado(@PathVariable Long id) {
		Empleado empleado = null;
		empleado = empleadoDriver.obtenerEmpleado(id);
		return empleado;
	}
	
	@PutMapping("/empleado/{id}")
	public void update(@RequestBody EmpleadoCommand empleadoCommand) {
		this.empleadoDriver.update(empleadoCommand);
	}
}
