package co.com.ceiba.adn.domain.service;

import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.port.repository.IBonificacionRepository;

public class BonificacionService {
	private IBonificacionRepository bonificacionRepository;
	
	public BonificacionService(IBonificacionRepository bonificacionRepository) {
		this.bonificacionRepository = bonificacionRepository;
	}
	
	public void insertarBonificacion(Bonificacion bonificacion) {
		this.bonificacionRepository.crearBonificacion(bonificacion);
	}
}
