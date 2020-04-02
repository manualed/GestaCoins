package co.com.ceiba.adn.domain.service;

import co.com.ceiba.adn.domain.model.entity.Transaccion;
import co.com.ceiba.adn.domain.port.repository.ITransaccionRepository;

public class TransaccionService {
	private ITransaccionRepository transaccionRepository;
	
	public TransaccionService(ITransaccionRepository transaccionRepository) {
		this.transaccionRepository = transaccionRepository;
	}
	
	public void insertarTransaccion(Transaccion transaccion) {
		this.transaccionRepository.crearTransaccion(transaccion);
	}
}
