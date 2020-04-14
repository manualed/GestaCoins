package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.infrastructure.entity.BonificacionEntity;

@Repository
public interface IBonificacionJpa extends JpaRepository<BonificacionEntity, Long> {
	
	List<BonificacionEntity> findAll();

	BonificacionEntity findById(@Param("id") long id);
}
