package co.com.ceiba.adn.domain.model.entity;

import java.util.Date;

public class Transaccion {
	private static final String EMPLEADO_OBLIGATORIO = "El empleado es obligatorio.";
	private static final String BONIFICACION_OBLIGATORIO = "La bonificacion es obligatoria.";
	private static final String REDIMIDO_OBLIGATORIO = "El campo redimido es obligatorio.";
	private static final String FECHA_OBTENCION_OBLIGATORIO = "La fecha de obtencion es obligatoria.";	

	private long idEmpleado;
	private long idBonificacion;
	private boolean redimido;
	private Date fechaObtencion;
	private Date fechaRedencion;

	public Transaccion(long idEmpleado, long idBonificacion, boolean redimido, Date fechaObtencion,
			Date fechaRedencion) {
		Validador.validarObligatoriedad(idEmpleado, EMPLEADO_OBLIGATORIO);
		Validador.validarObligatoriedad(idBonificacion, BONIFICACION_OBLIGATORIO);
		Validador.validarObligatoriedad(redimido, REDIMIDO_OBLIGATORIO);
		Validador.validarObligatoriedad(fechaObtencion, FECHA_OBTENCION_OBLIGATORIO);
		
		
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
