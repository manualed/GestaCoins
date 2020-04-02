package co.com.ceiba.adn.infrastructure.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bonificacion")
@Setter
@Getter
public class BonificacionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBonificacion;
	
	
	private String codigoBonificacion;
	
	private String nombreBonificacion;
	
	private long valorBonificacion;
	
	private int tipoBonificacion;
	
	@OneToMany(mappedBy = "bonificacion")
    private Set<TransactionEntity> transacciones;
	
}
