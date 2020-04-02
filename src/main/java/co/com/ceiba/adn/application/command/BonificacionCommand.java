package co.com.ceiba.adn.application.command;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class BonificacionCommand {
	private long idBonificacion;
	private String codigoBonificacion;
	private String nombreBonificacion;
	private long valorBonificacion;
	private int tipoBonificacion;
	
}
