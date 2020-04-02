package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.domain.model.entity.Transaccion;
import co.com.ceiba.adn.domain.port.repository.ITransaccionRepository;
import co.com.ceiba.adn.infrastructure.adapter.mapper.MapperTransaccion;
import co.com.ceiba.adn.infrastructure.entity.TransactionEntity;
@Repository
public class TransaccionJpa implements ITransaccionRepository{
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
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		TransactionEntity transaccionEntity = modelMapper.map(transaccion, TransactionEntity.class);
		transaccionJpaRepository.save(transaccionEntity);
	}

	@Override
	public List<Transaccion> listar() {
		 List<TransactionEntity> transactionEntity = this.transaccionJpaRepository.findAll();
	        return this.mapper.entityToModelList(transactionEntity);
	}
}
