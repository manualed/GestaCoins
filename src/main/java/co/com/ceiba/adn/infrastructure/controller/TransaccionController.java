package co.com.ceiba.adn.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.application.command.TransaccionCommand;
import co.com.ceiba.adn.application.driver.TransaccionDriver;

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
}
