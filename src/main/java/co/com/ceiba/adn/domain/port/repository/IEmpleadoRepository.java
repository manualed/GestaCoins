package co.com.ceiba.adn.domain.port.repository;

import java.util.List;

import co.com.ceiba.adn.domain.model.Empleado;

public interface IEmpleadoRepository {
	
	public void crearEmpleado(Empleado empleado);

	List<Empleado> listar(String cedula);
	
	boolean existeEmpleado(Empleado empleado);
}
