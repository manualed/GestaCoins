package co.com.ceiba.adn.infrastructure.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "transaccion")
public class TransactionEntity {
	@NotNull
	private long idEmpleado;
	@NotNull
	private long idBonificacion;
	@NotNull
	private boolean redimido;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaObtencion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaRedencion;
		
}


