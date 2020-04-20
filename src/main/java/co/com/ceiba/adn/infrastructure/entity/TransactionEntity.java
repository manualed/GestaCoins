package co.com.ceiba.adn.infrastructure.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Entity
@Table(name = "transaccion")
@Data
public class TransactionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTransaccion;
	
	@NotNull
	@Column(insertable = false, updatable = false)
	private long idEmpleado;
	
	@NotNull
	@Column(insertable = false, updatable = false)
	private long idBonificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpleado")
    EmpleadoEntity empleado;
	
	@ManyToOne(fetch = FetchType.LAZY)
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


