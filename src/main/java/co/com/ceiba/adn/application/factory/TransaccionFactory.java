package co.com.ceiba.adn.application.factory;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.application.command.TransaccionCommand;
import co.com.ceiba.adn.domain.model.entity.Transaccion;

@Component
public class TransaccionFactory {
	public Transaccion crearTransaccion(TransaccionCommand transaccionCommand) {
		return new Transaccion(
				transaccionCommand.getIdEmpleado(), 
				transaccionCommand.getIdBonificacion(), 
				transaccionCommand.isRedimido(), 
				transaccionCommand.getFechaObtencion(), 
				transaccionCommand.getFechaRedencion());
	}
}
