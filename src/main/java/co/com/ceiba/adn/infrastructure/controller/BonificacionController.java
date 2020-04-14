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

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.driver.BonificacionDriver;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/coins")
public class BonificacionController {
	
	private final BonificacionDriver bonificacionDriver;
	
	public BonificacionController(BonificacionDriver bonificacionDriver) {
		this.bonificacionDriver = bonificacionDriver;
	}
	
	@PostMapping(value = "/bonificacion")
	public void crearBonificacion(@RequestBody BonificacionCommand bonificacionCommand) {
		this.bonificacionDriver.insertarBonificacion(bonificacionCommand);
	}
	
	@GetMapping(value = "/bonificaciones")
	public List<Bonificacion> listar() {
		return this.bonificacionDriver.listar();
	}
	
	@DeleteMapping(value = "/bonificaciones/{id}")
	public void eliminar(@PathVariable long id) {
		this.bonificacionDriver.eliminar(id);
	}
	
	@GetMapping("/bonificacion/{id}")
	public Bonificacion obtenerBonificacion(@PathVariable Long id) {
		Bonificacion bonificacion = null;
		bonificacion = bonificacionDriver.obtenerBonificacion(id);
		return bonificacion;
	}
	
	@PutMapping("/bonificacion/{id}")
	public void update(@RequestBody BonificacionCommand bonificacionCommand) {
		this.bonificacionDriver.update(bonificacionCommand);
	}
	
}
