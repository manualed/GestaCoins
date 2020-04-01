package co.com.ceiba.adn.application.factory;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;

@Component
public class BonificacionFactory {
	public Bonificacion crearBonificacion(BonificacionCommand bonificacionCommand) {
		return new Bonificacion(
				bonificacionCommand.getIdBonificacion(), 
				bonificacionCommand.getCodigoBonificacion(), 
				bonificacionCommand.getNombreBonificacion(), 
				bonificacionCommand.getValorBonificacion(),
				bonificacionCommand.getTipoBonificacion());

	}
}
