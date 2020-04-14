package co.com.ceiba.adn.domain.model.entity;

import java.util.Date;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
@Generated
@Setter
@Getter
public class Transaccion {
	private static final String EMPLEADO_OBLIGATORIO = "El empleado es obligatorio.";
	private static final String BONIFICACION_OBLIGATORIO = "La bonificacion es obligatoria.";
	private static final String REDIMIDO_OBLIGATORIO = "El campo redimido es obligatorio.";
	private static final String FECHA_OBTENCION_OBLIGATORIO = "La fecha de obtencion es obligatoria.";	
	
	private static final String VALOR_IDBONIFICACION_DEBE_SER_MAYOR_A = "El id de la bonificacion debe ser mayor que %s";
	private static final Long VALOR_NO_VALIDO_ID_BONIFICACION = 0L;
	private static final String VALOR_IDEMPLEADO_DEBE_SER_MAYOR_A = "El id de la bonificacion debe ser mayor que %s";
	private static final Long VALOR_NO_VALIDO_ID_EMPLEADO = 0L;

	private long idTransaccion;
	private long idEmpleado;
	private long idBonificacion;
	private boolean redimido;
	private Date fechaObtencion;
	private Date fechaRedencion;
	private Empleado empleado;
	private Bonificacion bonificacion;

	public Transaccion(long idTransaccion, long idEmpleado, long idBonificacion, boolean redimido, Date fechaObtencion,
			Date fechaRedencion, Empleado empleado, Bonificacion bonificacion) {
		Validador.validarObligatoriedad(idEmpleado, EMPLEADO_OBLIGATORIO);
		Validador.validarObligatoriedad(idBonificacion, BONIFICACION_OBLIGATORIO);
		Validador.validarObligatoriedad(redimido, REDIMIDO_OBLIGATORIO);
		Validador.validarObligatoriedad(fechaObtencion, FECHA_OBTENCION_OBLIGATORIO);
		
		Validador.validarValorValido(idBonificacion, VALOR_NO_VALIDO_ID_BONIFICACION , VALOR_IDBONIFICACION_DEBE_SER_MAYOR_A);
		Validador.validarValorValido(idEmpleado, VALOR_NO_VALIDO_ID_EMPLEADO , VALOR_IDEMPLEADO_DEBE_SER_MAYOR_A);
		
		this.idTransaccion = idTransaccion;
		this.idEmpleado = idEmpleado;
		this.idBonificacion = idBonificacion;
		this.redimido = redimido;
		this.fechaObtencion = fechaObtencion;
		this.fechaRedencion = fechaRedencion;
		this.empleado = empleado;
		this.bonificacion = bonificacion;
	}
	

	
	public long getIdTransaccion() {
		return idTransaccion;
	}



	public void setIdTransaccion(long idTransaccion) {
		this.idTransaccion = idTransaccion;
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Bonificacion getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(Bonificacion bonificacion) {
		this.bonificacion = bonificacion;
	}
	
	

}
