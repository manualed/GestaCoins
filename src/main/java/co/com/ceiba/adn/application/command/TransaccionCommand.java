package co.com.ceiba.adn.application.command;

import java.util.Date;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Generated
@Setter
@Getter
public class TransaccionCommand {
	private long idEmpleado;
	private long idBonificacion;
	private boolean redimido;
	private Date fechaObtencion;
	private Date fechaRedencion;

	public TransaccionCommand(long idEmpleado, long idBonificacion, boolean redimido, Date fechaObtencion,
			Date fechaRedencion) {
		this.idEmpleado = idEmpleado;
		this.idBonificacion = idBonificacion;
		this.redimido = redimido;
		this.fechaObtencion = fechaObtencion;
		this.fechaRedencion = fechaRedencion;
	}

	public TransaccionCommand() {
	}

}
