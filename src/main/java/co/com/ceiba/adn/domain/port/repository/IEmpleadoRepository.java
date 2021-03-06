package co.com.ceiba.adn.domain.port.repository;

import java.util.List;

import co.com.ceiba.adn.domain.model.entity.Empleado;

public interface IEmpleadoRepository {
	
	public void crearEmpleado(Empleado empleado);

	List<Empleado> listar();
	
	void eliminar(long id);
	
	Empleado obtenerEmpleado(long id);
	
	public void updateEmpleado(Empleado empleado);
}
