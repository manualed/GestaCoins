package co.com.ceiba.adn.infrastructure.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "transaccion")
@Setter
@Getter
@Generated
public class TransactionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "idEmpleado")
    EmpleadoEntity empleado;
	
	@ManyToOne
    @JoinColumn(name = "idBonificacion")
    BonificacionEntity bonificacion;
	
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


