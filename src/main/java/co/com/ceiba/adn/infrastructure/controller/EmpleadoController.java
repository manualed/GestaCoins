package co.com.ceiba.adn.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.application.driver.EmpleadoDriver;
import co.com.ceiba.adn.domain.model.entity.Empleado;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	private final EmpleadoDriver empleadoDriver;
	
	public EmpleadoController(EmpleadoDriver empleadoDriver) {
		this.empleadoDriver = empleadoDriver;
	}
	
	
//	@GetMapping("/clientes")
//	public List<Empleado> index() {
//		return clienteService.findAll();
//	}
	@PostMapping
	public void crearEmpleado(@RequestBody EmpleadoCommand empleadoCommand) {
		this.empleadoDriver.insertarEmpleado(empleadoCommand);
	}
}
