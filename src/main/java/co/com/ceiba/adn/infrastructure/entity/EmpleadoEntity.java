package co.com.ceiba.adn.infrastructure.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleado")
@Setter
@Getter
@Generated
public class EmpleadoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;

	
	private String tipoDocumento;
	
	
	private String numeroDocumento;
	
	
	private String primerNombre;
	
	
	private String primerApellido;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaIngreso;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaCambio;
	
	@NotEmpty
	@Email
	private String email;
	

	@OneToMany(mappedBy = "empleado")
    private Set<TransactionEntity> transacciones;


}
