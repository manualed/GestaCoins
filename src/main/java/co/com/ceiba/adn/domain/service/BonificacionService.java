package co.com.ceiba.adn.domain.service;

import java.util.List;

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
	
	public List<Bonificacion> listar() {
		return this.bonificacionRepository.listar();
	}
}
