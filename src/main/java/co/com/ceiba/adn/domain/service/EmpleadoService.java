package co.com.ceiba.adn.domain.service;

import java.util.List;

import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.port.repository.IEmpleadoRepository;

public class EmpleadoService {
	
	private IEmpleadoRepository empleadoRepository;
	
	public EmpleadoService(IEmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	public void insertarEmpleado(Empleado empleado) {
		this.empleadoRepository.crearEmpleado(empleado);
	}
	

	public List<Empleado> listar() {
		return this.empleadoRepository.listar();
	}
	
}
