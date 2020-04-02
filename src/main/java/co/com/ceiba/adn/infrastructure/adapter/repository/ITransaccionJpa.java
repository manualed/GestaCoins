package co.com.ceiba.adn.infrastructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.infrastructure.entity.TransactionEntity;

@Repository
public interface ITransaccionJpa extends JpaRepository<TransactionEntity, Long> {

}
