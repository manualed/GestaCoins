package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;

@Repository
public interface IEmpleadoJpa extends JpaRepository<EmpleadoEntity, Long> {
	
	List<EmpleadoEntity> findAll();
	 
	@Query(value = "SELECT * FROM empleado WHERE idEmpleado = :id", nativeQuery = true)
	EmpleadoEntity findById(@Param("id") long id);
}
