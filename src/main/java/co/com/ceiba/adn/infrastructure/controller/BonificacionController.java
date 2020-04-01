package co.com.ceiba.adn.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.driver.BonificacionDriver;

@RestController
@RequestMapping("/api/coins")
public class BonificacionController {
	
	private final BonificacionDriver bonificacionDriver;
	
	public BonificacionController(BonificacionDriver bonificacionDriver) {
		this.bonificacionDriver = bonificacionDriver;
	}
	
	@PostMapping(value = "/bonificacion")
	public void crearEmpleado(@RequestBody BonificacionCommand bonificacionCommand) {
		this.bonificacionDriver.insertarBonificacion(bonificacionCommand);
	}
}