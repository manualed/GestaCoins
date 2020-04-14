package co.com.ceiba.adn.domain.port.repository;

import java.util.List;

import co.com.ceiba.adn.domain.model.entity.Bonificacion;

public interface IBonificacionRepository {
	
	public void crearBonificacion(Bonificacion bonificacion);
	
	List<Bonificacion> listar();
	
	void eliminar(long id);
	
	Bonificacion obtenerBonificacion(long id);
	
	public void updateBonificacion(Bonificacion bonificacion);
	
}
