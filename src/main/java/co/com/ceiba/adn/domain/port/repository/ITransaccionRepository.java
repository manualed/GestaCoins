package co.com.ceiba.adn.domain.port.repository;

import java.util.List;

import co.com.ceiba.adn.domain.model.entity.Transaccion;

public interface ITransaccionRepository {

	public void crearTransaccion(Transaccion transaccion);

	List<Transaccion> listar(String cedula);

}
