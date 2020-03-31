package co.com.ceiba.adn.infrastructure.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import co.com.ceiba.adn.domain.model.entity.Bonificacion;

@Entity
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;

	@NotNull
	private String tipoDocumento;
	
	@NotNull
	private String numeroDocumento;
	
	@NotNull
	private String primerNombre;
	
	@NotNull
	private String primerApellido;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaIngreso;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaCambio;
	
	@NotEmpty
	@Email
	private String email;
	

	    @ManyToMany(cascade = {
	    	    CascadeType.PERSIST,
	    	    CascadeType.MERGE
	    	})
		@JoinTable(
		        name = "transaccion", joinColumns = @JoinColumn(name = "idEmpleado", nullable = false),
		        inverseJoinColumns = @JoinColumn(name="idBonificacion", nullable = false)
		    )
	
	private Set<Bonificacion> bonificaciones = new HashSet<>();
	
	public void addBonificaciones(Bonificacion bonificacion) {
        this.bonificaciones.add(bonificacion);
	}
	

	@Override
	public String toString() {
		return primerNombre + " " + primerApellido;
	}

}
