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
	public void eliminar(long id) {
		this.bonificacionRepository.eliminar(id);
	}
	
	public Bonificacion obtenerBonificacion(long id) {
		return this.bonificacionRepository.obtenerBonificacion(id);
	}
	public void updateBonificacion(Bonificacion bonificacion) {
		this.bonificacionRepository.updateBonificacion(bonificacion);
	}
}
