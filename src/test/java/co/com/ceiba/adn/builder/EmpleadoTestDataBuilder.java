package co.com.ceiba.adn.builder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ceiba.adn.domain.model.Empleado;
import co.com.ceiba.adn.domain.model.Transaccion;

public class EmpleadoTestDataBuilder {

	private long idEmpleado;
	private String tipoDocumento;
	private String numeroDocumento;
	private String primerNombre;
	private String primerApellido;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Date fechaCambio;
	private String email;
	private List<Transaccion> transacciones;

	public EmpleadoTestDataBuilder() {
		this.idEmpleado = 1;
		this.tipoDocumento = "CC";
		this.numeroDocumento = "882829111";
		this.primerNombre = "MANUEL";
		this.primerApellido = "DURANGO";
		this.fechaIngreso = new Calendar.Builder().setDate(2012, 6, 4).build().getTime();
		this.fechaNacimiento = new Calendar.Builder().setDate(1983, 6, 6).build().getTime();
		this.fechaCambio = new Calendar.Builder().setInstant(Instant.now().getEpochSecond()).build().getTime();
		this.email = "manuel.durango@ceiba.com.co";
	}

	
	public EmpleadoTestDataBuilder with(TransaccionTestDataBuilder... transaccionTestDataBuilders){
        transacciones = new ArrayList<Transaccion>();
        for(TransaccionTestDataBuilder transactionBuilder: transaccionTestDataBuilders){
        	transacciones.add(transactionBuilder.build());
        }
        return this;
    }
	public EmpleadoTestDataBuilder conIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
		return this;
	}

	public EmpleadoTestDataBuilder conTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
		return this;
	}

	public EmpleadoTestDataBuilder conNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
		return this;
	}

	public EmpleadoTestDataBuilder conPrimerNombre(String nombre) {
		this.primerNombre = nombre;
		return this;
	}

	public EmpleadoTestDataBuilder conPrimerApellido(String apellido) {
		this.primerApellido = apellido;
		return this;
	}

	public EmpleadoTestDataBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}

	public EmpleadoTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public EmpleadoTestDataBuilder conFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
		return this;
	}

	public EmpleadoTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}

	public Empleado build() {
		return new Empleado(idEmpleado, tipoDocumento, numeroDocumento, primerNombre, primerApellido, fechaIngreso,
				fechaNacimiento, fechaCambio, email);
	}
	
	public static EmpleadoTestDataBuilder unEmpleado(){
        return new EmpleadoTestDataBuilder();
    }

}
