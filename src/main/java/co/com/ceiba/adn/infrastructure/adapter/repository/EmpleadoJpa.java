package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.port.repository.IEmpleadoRepository;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;

public class EmpleadoJpa implements IEmpleadoRepository{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private final IEmpleadoJpa empleadoJpa;
	
	public EmpleadoJpa(IEmpleadoJpa empleadoJpa) {
		this.empleadoJpa = empleadoJpa;
	}
	@Override
	public void crearEmpleado(Empleado empleado) {
		EmpleadoEntity empleadoEntity = modelMapper.map(empleado, EmpleadoEntity.class);
		empleadoJpa.save(empleadoEntity);
		
	}

	@Override
	public List<Empleado> listar(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return false;
	}

}
