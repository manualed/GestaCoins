package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.application.command.TransaccionCommand;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.model.entity.Transaccion;
import co.com.ceiba.adn.domain.port.repository.ITransaccionRepository;
import co.com.ceiba.adn.infrastructure.adapter.mapper.MapperTransaccion;
import co.com.ceiba.adn.infrastructure.entity.BonificacionEntity;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;
import co.com.ceiba.adn.infrastructure.entity.TransactionEntity;

@Repository
public class TransaccionJpa implements ITransaccionRepository {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private final ITransaccionJpa transaccionJpaRepository;

	private MapperTransaccion mapper = new MapperTransaccion();

	public TransaccionJpa(ITransaccionJpa transaccionJpa) {
		this.transaccionJpaRepository = transaccionJpa;
	}

	@Override
	public void crearTransaccion(Transaccion transaccion) {
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
		empleadoEntity.setIdEmpleado(transaccion.getIdEmpleado());
		BonificacionEntity bonificacionEntity = new BonificacionEntity();
		bonificacionEntity.setIdBonificacion(transaccion.getIdBonificacion());

		TransactionEntity transaccionEntity = new TransactionEntity();
		transaccionEntity.setBonificacion(bonificacionEntity);
		transaccionEntity.setEmpleado(empleadoEntity);
		transaccionEntity.setIdBonificacion(transaccion.getIdBonificacion());
		transaccionEntity.setIdEmpleado(transaccion.getIdEmpleado());
		transaccionEntity.setRedimido(transaccion.isRedimido());
		transaccionEntity.setFechaObtencion(transaccion.getFechaObtencion());
		transaccionEntity.setFechaRedencion(transaccion.getFechaRedencion());
		this.transaccionJpaRepository.save(transaccionEntity);
	}

	@Override
	public List<Transaccion> listar() {
		List<TransactionEntity> transactionEntity = this.transaccionJpaRepository.listarTransaccion();
		return this.mapper.entityToModelList(transactionEntity);
	}

	@Override
	public void eliminar(long id) {
		this.transaccionJpaRepository.deleteById(id);

	}

	@Override
	public Transaccion obtenerTransaccion(long id) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		TransactionEntity entity = this.transaccionJpaRepository.findById(id);
		EmpleadoEntity empleadoEntity = entity.getEmpleado();
		BonificacionEntity bonificacionEntity = entity.getBonificacion();
		TransaccionCommand transaccionCommand = modelMapper.map(entity, TransaccionCommand.class);
		EmpleadoCommand empleadoCommand = new EmpleadoCommand(empleadoEntity.getIdEmpleado(),
				empleadoEntity.getTipoDocumento(), empleadoEntity.getNumeroDocumento(),
				empleadoEntity.getPrimerNombre(), empleadoEntity.getPrimerApellido(), empleadoEntity.getFechaIngreso(),
				empleadoEntity.getFechaNacimiento(), empleadoEntity.getFechaCambio(), empleadoEntity.getEmail());

		BonificacionCommand bonificacionCommand = new BonificacionCommand(bonificacionEntity.getIdBonificacion(),
				bonificacionEntity.getCodigoBonificacion(), bonificacionEntity.getNombreBonificacion(),
				bonificacionEntity.getValorBonificacion(), bonificacionEntity.getTipoBonificacion());
		return new Transaccion(transaccionCommand.getIdTransaccion(), transaccionCommand.getIdEmpleado(), transaccionCommand.getIdBonificacion(),
				transaccionCommand.isRedimido(), transaccionCommand.getFechaObtencion(),
				transaccionCommand.getFechaRedencion(),
				new Empleado(empleadoCommand.getIdEmpleado(), empleadoCommand.getTipoDocumento(),
						empleadoCommand.getNumeroDocumento(), empleadoCommand.getPrimerNombre(),
						empleadoCommand.getPrimerApellido(), empleadoCommand.getFechaIngreso(),
						empleadoCommand.getFechaNacimiento(), empleadoCommand.getFechaCambio(),
						empleadoCommand.getEmail()),
				new Bonificacion(bonificacionCommand.getIdBonificacion(), bonificacionCommand.getCodigoBonificacion(),
						bonificacionCommand.getNombreBonificacion(), bonificacionCommand.getValorBonificacion(),
						bonificacionCommand.getTipoBonificacion()));

	}

	@Override
	public void updateTransaccion(Transaccion transaccion) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
		empleadoEntity.setIdEmpleado(transaccion.getIdEmpleado());
		BonificacionEntity bonificacionEntity = new BonificacionEntity();
		bonificacionEntity.setIdBonificacion(transaccion.getIdBonificacion());
		TransactionEntity transactionEntity = modelMapper.map(transaccion, TransactionEntity.class);
		transactionEntity.setBonificacion(bonificacionEntity);
		transactionEntity.setEmpleado(empleadoEntity);
		this.transaccionJpaRepository.save(transactionEntity);

	}
}
