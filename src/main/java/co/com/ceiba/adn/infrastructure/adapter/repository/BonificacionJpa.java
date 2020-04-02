package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.port.repository.IBonificacionRepository;
import co.com.ceiba.adn.infrastructure.adapter.mapper.MapperBonificacion;
import co.com.ceiba.adn.infrastructure.entity.BonificacionEntity;
@Repository
public class BonificacionJpa implements IBonificacionRepository{

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private final IBonificacionJpa bonificacionJpaRepository;
	
	private MapperBonificacion mapper = new MapperBonificacion();
	
	public BonificacionJpa(IBonificacionJpa bonificacionJpa) {
		this.bonificacionJpaRepository = bonificacionJpa;
	}
	
	@Override
	public void crearBonificacion(Bonificacion bonificacion) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		BonificacionEntity bonificacionEntity = modelMapper.map(bonificacion, BonificacionEntity.class);
		bonificacionJpaRepository.save(bonificacionEntity);
	}

	@Override
	public List<Bonificacion> listar() {
        List<BonificacionEntity> bonificacionEntity = this.bonificacionJpaRepository.findAll();
        return this.mapper.entityToModelList(bonificacionEntity);
	}

}
