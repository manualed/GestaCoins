package co.com.ceiba.adn.domain.model.entity;

import java.util.Date;

public class Transaccion {

	private long idEmpleado;
	private long idBonificacion;
	private boolean redimido;
	private Date fechaObtencion;
	private Date fechaRedencion;

	public Transaccion(long idEmpleado, long idBonificacion, boolean redimido, Date fechaObtencion,
			Date fechaRedencion) {
		this.idEmpleado = idEmpleado;
		this.idBonificacion = idBonificacion;
		this.redimido = redimido;
		this.fechaObtencion = fechaObtencion;
		this.fechaRedencion = fechaRedencion;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public long getIdBonificacion() {
		return idBonificacion;
	}

	public void setIdBonificacion(long idBonificacion) {
		this.idBonificacion = idBonificacion;
	}

	public boolean isRedimido() {
		return redimido;
	}

	public void setRedimido(boolean redimido) {
		this.redimido = redimido;
	}

	public Date getFechaObtencion() {
		return fechaObtencion;
	}

	public void setFechaObtencion(Date fechaObtencion) {
		this.fechaObtencion = fechaObtencion;
	}

	public Date getFechaRedencion() {
		return fechaRedencion;
	}

	public void setFechaRedencion(Date fechaRedencion) {
		this.fechaRedencion = fechaRedencion;
	}

}
