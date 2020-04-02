package co.com.ceiba.adn.application.command;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
@Generated
@Setter
@Getter
public class BonificacionCommand {
	private long idBonificacion;
	private String codigoBonificacion;
	private String nombreBonificacion;
	private long valorBonificacion;
	private int tipoBonificacion;

	public BonificacionCommand(long idBonificacion, String codigoBonificacion, String nombreBonificacion,
			long valorBonificacion, int tipoBonificacion) {
		this.idBonificacion = idBonificacion;
		this.codigoBonificacion = codigoBonificacion;
		this.nombreBonificacion = nombreBonificacion;
		this.valorBonificacion = valorBonificacion;
		this.tipoBonificacion = tipoBonificacion;
	}

	public BonificacionCommand() {
		
	}


	
}
