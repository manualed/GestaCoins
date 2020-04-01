package co.com.ceiba.adn.application.driver;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.factory.BonificacionFactory;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.service.BonificacionService;

@Component
public class BonificacionDriver {
	private final BonificacionService bonificacionService;
	private final BonificacionFactory bonificacionFactory;

	public BonificacionDriver(BonificacionService bonificacionService,BonificacionFactory bonificacionFactory) {
		this.bonificacionService = bonificacionService;
		this.bonificacionFactory = bonificacionFactory;
	}

	public void insertarBonificacion(BonificacionCommand bonificacionCommand) {
		Bonificacion bonificacion = this.bonificacionFactory.crearBonificacion(bonificacionCommand);
		this.bonificacionService.insertarBonificacion(bonificacion);
	}
}
