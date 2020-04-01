package co.com.ceiba.adn.infrastructure.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bonificacion")
public class BonificacionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBonificacion;
	
	@NotNull
	private String codigoBonificacion;
	@NotNull
	private String nombreBonificacion;
	@NotNull
	private long valorBonificacion;
	@NotNull
	private int tipoBonificacion;
	
	@OneToMany(mappedBy = "bonificacion")
    Set<TransactionEntity> transacciones;
	
}
