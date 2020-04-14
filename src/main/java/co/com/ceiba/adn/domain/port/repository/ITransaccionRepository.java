package co.com.ceiba.adn.domain.port.repository;

import java.util.List;

import co.com.ceiba.adn.domain.model.entity.Transaccion;

public interface ITransaccionRepository {

	public void crearTransaccion(Transaccion transaccion);

	List<Transaccion> listar();
	
	void eliminar(long id);
	
	Transaccion obtenerTransaccion(long id);
	
	public void updateTransaccion(Transaccion transaccion);

}
