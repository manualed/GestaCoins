package co.com.ceiba.adn.application.command;

import java.util.Date;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Generated
@Setter
@Getter
public class TransaccionCommand {
	private long idTransaccion;
	private long idEmpleado;
	private long idBonificacion;
	private boolean redimido;
	private Date fechaObtencion;
	private Date fechaRedencion;
	private EmpleadoCommand empleadoCommand;
	private BonificacionCommand bonificacionCommand;

	public TransaccionCommand(long idTransaccion, long idEmpleado, long idBonificacion, boolean redimido, Date fechaObtencion,
			Date fechaRedencion, EmpleadoCommand empleadoCommand, BonificacionCommand bonificacionCommand) {
		this.idTransaccion = idTransaccion;
		this.idEmpleado = idEmpleado;
		this.idBonificacion = idBonificacion;
		this.redimido = redimido;
		this.fechaObtencion = fechaObtencion;
		this.fechaRedencion = fechaRedencion;
		this.empleadoCommand = empleadoCommand;
		this.bonificacionCommand = bonificacionCommand;
	}

	public TransaccionCommand() {
	}

}
