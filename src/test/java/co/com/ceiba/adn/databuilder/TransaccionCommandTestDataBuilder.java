package co.com.ceiba.adn.databuilder;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.application.command.TransaccionCommand;

public class TransaccionCommandTestDataBuilder {
	private long idTransaccion;
	private long idEmpleado;
	private long idBonificacion;
	private boolean redimido;
	private Date fechaObtencion;
	private Date fechaRedencion;
	private EmpleadoCommand empleadoCommand;
	private BonificacionCommand bonificacionCommand;
	
	public TransaccionCommandTestDataBuilder() {
		this.idTransaccion =1;
		this.idEmpleado = 1;
		this.idBonificacion = 1;
		this.redimido = false;
		this.fechaObtencion = new Calendar.Builder().setDate(2020, 6, 4).build().getTime();
		this.fechaRedencion = new Calendar.Builder().setDate(2020, 8, 4).build().getTime();
		this.empleadoCommand = new EmpleadoCommandTestDataBuilder().build();
		this.bonificacionCommand = new BonificacionCommandTestDataBuilder().build();
	}
	public TransaccionCommandTestDataBuilder conIdTransaccion(long idTransaccion) {
		this.idTransaccion = idTransaccion;
		return this;
	}
	public TransaccionCommandTestDataBuilder conIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
		return this;
	}
	public TransaccionCommandTestDataBuilder conIdBonificacion(long idBonificacion) {
		this.idBonificacion = idBonificacion;
		return this;
	}
	public TransaccionCommandTestDataBuilder esRedimido(boolean redimido) {
		this.redimido = redimido;
		return this;
	}
	public TransaccionCommandTestDataBuilder conFechaObtencion(Date fechaObtencion) {
		this.fechaObtencion = fechaObtencion;
		return this;
	}
	public TransaccionCommandTestDataBuilder conFechaRedencion(Date fechaRedencion) {
		this.fechaRedencion = fechaRedencion;
		return this;
	}
	public TransaccionCommandTestDataBuilder conBonificacionCommand(BonificacionCommand bonificacionCommand) {
		this.bonificacionCommand = bonificacionCommand;
		return this;
	}
	public TransaccionCommandTestDataBuilder conEmpleadoCommand(EmpleadoCommand empleadoCommand) {
		this.empleadoCommand = empleadoCommand;
		return this;
	}
	public TransaccionCommand build() {
		return new TransaccionCommand(idTransaccion, idEmpleado, idBonificacion, redimido, fechaObtencion, fechaRedencion,empleadoCommand, bonificacionCommand);
	}
	
}
