package co.com.ceiba.adn.domain.service;

import co.com.ceiba.adn.domain.exception.DuplicityException;
import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.port.repository.IEmpleadoRepository;

public class EmpleadoService {
	private static final String EMPLEADO_EXISTENTE = "El empleado ya existe en el sistema.";
	
	private IEmpleadoRepository empleadoRepository;
	
	public EmpleadoService(IEmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	public void insertarEmpleado(Empleado empleado) {
		existeEmpleado(empleado);
		this.empleadoRepository.crearEmpleado(empleado);
	}
	
	private void existeEmpleado(Empleado empleado) {
		boolean existe = this.empleadoRepository.existeEmpleado(empleado);
		if (existe) {
			throw new DuplicityException(EMPLEADO_EXISTENTE);
		}
	}
	
}
