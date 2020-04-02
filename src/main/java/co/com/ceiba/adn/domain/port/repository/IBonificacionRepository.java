package co.com.ceiba.adn.domain.port.repository;

import java.util.List;

import co.com.ceiba.adn.domain.model.entity.Bonificacion;

public interface IBonificacionRepository {
	
	public void crearBonificacion(Bonificacion bonificacion);
	
	List<Bonificacion> listar();
	
}
