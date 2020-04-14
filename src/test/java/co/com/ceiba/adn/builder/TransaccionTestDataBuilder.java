package co.com.ceiba.adn.builder;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.model.entity.Transaccion;

public class TransaccionTestDataBuilder {
	private long idTransaccion;
	private long idEmpleado;
	private long idBonificacion;
	private boolean redimido;
	private Date fechaObtencion;
	private Date fechaRedencion;
	private Empleado empleado;
	private Bonificacion bonificacion;
	

	public TransaccionTestDataBuilder() {
		this.idTransaccion =1;
		this.idEmpleado = 1;
		this.idBonificacion = 1;
		this.redimido = true;
		this.fechaObtencion = new Calendar.Builder().setDate(2019, 6, 4).build().getTime();
		this.fechaRedencion = new Calendar.Builder().setDate(2019, 8, 4).build().getTime();
		this.empleado = new EmpleadoTestDataBuilder().build();
		this.bonificacion = new BonificacionTestDataBuilder().build();
	}
	
	public TransaccionTestDataBuilder conIdTransaccion(long idTransaccion) {
		this.idTransaccion = idTransaccion;
		return this;
	}

	public TransaccionTestDataBuilder conIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
		return this;
	}
	public TransaccionTestDataBuilder conIdBonificacion(long idBonificacion) {
		this.idBonificacion = idBonificacion;
		return this;
	}
	public TransaccionTestDataBuilder esRedimido(boolean redimido) {
		this.redimido = redimido;
		return this;
	}
	public TransaccionTestDataBuilder conFechaObtencion(Date fechaObtencion) {
		this.fechaObtencion = fechaObtencion;
		return this;
	}
	public TransaccionTestDataBuilder conFechaRedencion(Date fechaRedencion) {
		this.fechaRedencion = fechaRedencion;
		return this;
	}
	
	public Transaccion build() {
		return new Transaccion(idTransaccion,idEmpleado, idBonificacion, redimido, fechaObtencion, fechaRedencion,empleado,bonificacion);
	}	

}
