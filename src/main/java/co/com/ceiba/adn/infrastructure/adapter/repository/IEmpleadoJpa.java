package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.infrastructure.entity.BonificacionEntity;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;

@Repository
public interface IEmpleadoJpa extends JpaRepository<EmpleadoEntity, Long> {
	List<BonificacionEntity> findByEmpleado(EmpleadoEntity empleado);
}
