package co.com.ceiba.adn.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.infrastructure.entity.TransactionEntity;

@Repository
public interface ITransaccionJpa extends JpaRepository<TransactionEntity, Long> {
	
	@Query(value="SELECT * FROM TRANSACCION E JOIN EMPLEADO D ON E.ID_EMPLEADO= D.ID_EMPLEADO",  nativeQuery = true)
	public List<TransactionEntity> listarTransaccion();
		
	TransactionEntity findById(@Param("id") long id);
}
