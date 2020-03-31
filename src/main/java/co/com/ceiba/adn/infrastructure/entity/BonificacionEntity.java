package co.com.ceiba.adn.infrastructure.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import co.com.ceiba.adn.domain.model.Empleado;

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
	
	@ManyToMany(mappedBy = "bonificacion")
    private Collection<Empleado> empleados;
}
