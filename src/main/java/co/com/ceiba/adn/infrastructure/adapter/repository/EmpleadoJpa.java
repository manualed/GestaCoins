package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.port.repository.IEmpleadoRepository;
import co.com.ceiba.adn.infrastructure.adapter.mapper.Mapper;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;
@Repository
public class EmpleadoJpa implements IEmpleadoRepository{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private final IEmpleadoJpa empleadoJpa;
	
	private Mapper mapper = new Mapper();
	
	public EmpleadoJpa(IEmpleadoJpa empleadoJpa) {
		this.empleadoJpa = empleadoJpa;
	}
	@Override
	public void crearEmpleado(Empleado empleado) {
		EmpleadoEntity empleadoEntity = modelMapper.map(empleado, EmpleadoEntity.class);
		empleadoJpa.save(empleadoEntity);
		
	}

	@Override
    public List<Empleado> listar() {
        List<EmpleadoEntity> empleadoEntity = this.empleadoJpa.findAll();
        return this.mapper.entityToModelList(empleadoEntity);
    }


}
