package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.port.repository.IEmpleadoRepository;
import co.com.ceiba.adn.infrastructure.adapter.mapper.MapperEmpleado;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;
@Repository
public class EmpleadoJpa implements IEmpleadoRepository{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private final IEmpleadoJpa empleadoJpaRepository;
	
	private MapperEmpleado mapper = new MapperEmpleado();
	
	public EmpleadoJpa(IEmpleadoJpa empleadoJpa) {
		this.empleadoJpaRepository = empleadoJpa;
	}
	@Override
	public void crearEmpleado(Empleado empleado) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		EmpleadoEntity empleadoEntity = modelMapper.map(empleado, EmpleadoEntity.class);
		empleadoJpaRepository.save(empleadoEntity);
		
	}

	@Override
    public List<Empleado> listar() {
        List<EmpleadoEntity> empleadoEntity = this.empleadoJpaRepository.findAll();
        return this.mapper.entityToModelList(empleadoEntity);
    }
	@Override
	public void eliminar(long id) {
		empleadoJpaRepository.deleteById(id);
		
	}
	
	@Override
	public Empleado obtenerEmpleado(long id) {
		modelMapper = new ModelMapper(); 
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		EmpleadoEntity entity = empleadoJpaRepository.findById(id);
		EmpleadoCommand empleadoCommand = modelMapper.map(entity, EmpleadoCommand.class);
		return new Empleado(empleadoCommand.getIdEmpleado(), empleadoCommand.getTipoDocumento(), empleadoCommand.getNumeroDocumento(), 
				empleadoCommand.getPrimerNombre(),empleadoCommand.getPrimerApellido(), empleadoCommand.getFechaIngreso(), 
				empleadoCommand.getFechaNacimiento(),empleadoCommand.getFechaCambio(),empleadoCommand.getEmail());
	}
	
	@Override
	public void updateEmpleado(Empleado empleado) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		EmpleadoEntity empleadoEntity = modelMapper.map(empleado, EmpleadoEntity.class);
		empleadoJpaRepository.save(empleadoEntity);
		
	}

}
