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

import co.com.ceiba.adn.application.command.TransaccionCommand;
import co.com.ceiba.adn.application.driver.TransaccionDriver;
import co.com.ceiba.adn.domain.model.entity.Transaccion;
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/coins")
public class TransaccionController {
	private final TransaccionDriver transaccionDriver;

	public TransaccionController(TransaccionDriver transaccionDriver) {
		this.transaccionDriver = transaccionDriver;
	}

	@PostMapping(value = "/transaccion")
	public void crearTransaccion(@RequestBody TransaccionCommand transaccionCommand) {
		this.transaccionDriver.insertarTransaccion(transaccionCommand);
	}
	@GetMapping(value = "/transacciones")
	public List<Transaccion> listar() {
		return this.transaccionDriver.listar();
	}
	@DeleteMapping(value = "/transacciones/{id}")
	public void eliminar(@PathVariable long id) {
		this.transaccionDriver.eliminar(id);
	}
	
	@GetMapping("/transaccion/{id}")
	public Transaccion obtenerTransaccion(@PathVariable Long id) {
		Transaccion transaccion = null;
		transaccion = transaccionDriver.obtenerTransaccion(id);
		return transaccion;
	}
	
	@PutMapping("/transaccion/{id}")
	public void update(@RequestBody TransaccionCommand transaccionCommand) {
		this.transaccionDriver.update(transaccionCommand);
	}
	
}
