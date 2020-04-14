package co.com.ceiba.adn.application.driver;

import java.util.List;

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
	
	public List<Transaccion> listar(){
		return this.transaccionService.listar();
	}
	
	public void eliminar(long id) {
		this.transaccionService.eliminar(id);
	}
	
	public Transaccion obtenerTransaccion(long id) {
		return this.transaccionService.obtenerTransaccion(id);
	}
	
	public void update(TransaccionCommand transaccionCommand) {
		Transaccion transaccion = this.transaccionFactory.crearTransaccion(transaccionCommand);
		this.transaccionService.updateTransaccion(transaccion);
	}
}
