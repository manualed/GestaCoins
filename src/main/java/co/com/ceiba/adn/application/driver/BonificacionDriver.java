package co.com.ceiba.adn.application.driver;

import java.util.List;

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
	
	public List<Bonificacion> listar(){
		return this.bonificacionService.listar();
	}
	
	public void eliminar(long id) {
		this.bonificacionService.eliminar(id);
	}
	
	public Bonificacion obtenerBonificacion(long id) {
		return this.bonificacionService.obtenerBonificacion(id);
	}
	
	public void update(BonificacionCommand bonificacionCommand) {
		Bonificacion bonificacion = this.bonificacionFactory.crearBonificacion(bonificacionCommand);
		this.bonificacionService.updateBonificacion(bonificacion);
	}
}
