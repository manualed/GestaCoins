package co.com.ceiba.adn.application.driver;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.application.command.TransaccionCommand;
import co.com.ceiba.adn.application.factory.TransaccionFactory;
import co.com.ceiba.adn.domain.model.entity.Transaccion;
import co.com.ceiba.adn.domain.service.TransaccionService;
@Component
public class TransaccionDriver {
	private final TransaccionService transaccionService;
	private final TransaccionFactory transaccionFactory;

	public TransaccionDriver(TransaccionService transaccionService,TransaccionFactory transaccionFactory) {
		this.transaccionService = transaccionService;
		this.transaccionFactory = transaccionFactory;
	}

	public void insertarTransaccion(TransaccionCommand transaccionCommand) {
		Transaccion transaccion = this.transaccionFactory.crearTransaccion(transaccionCommand);
		this.transaccionService.insertarTransaccion(transaccion);
	}
}
