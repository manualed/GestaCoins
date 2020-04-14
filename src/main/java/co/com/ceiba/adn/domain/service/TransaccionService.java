package co.com.ceiba.adn.domain.service;

import java.util.List;

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
	
	public List<Transaccion> listar() {
		return this.transaccionRepository.listar();
	}
	
	public void eliminar(long id) {
		this.transaccionRepository.eliminar(id);
	}
	
	public Transaccion obtenerTransaccion(long id) {
		return this.transaccionRepository.obtenerTransaccion(id);
	}
	public void updateTransaccion(Transaccion transaccion) {
		this.transaccionRepository.updateTransaccion(transaccion);
	}
}
