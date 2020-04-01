package co.com.ceiba.adn.infrastructure.adapter.repository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.port.repository.IBonificacionRepository;
import co.com.ceiba.adn.infrastructure.entity.BonificacionEntity;
@Repository
public class BonificacionJpa implements IBonificacionRepository{

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private final IBonificacionJpa bonificacionJpaRepository;
	
	public BonificacionJpa(IBonificacionJpa bonificacionJpa) {
		this.bonificacionJpaRepository = bonificacionJpa;
	}
	
	@Override
	public void crearBonificacion(Bonificacion bonificacion) {
		BonificacionEntity bonificacionEntity = modelMapper.map(bonificacion, BonificacionEntity.class);
		bonificacionJpaRepository.save(bonificacionEntity);
	}

}
