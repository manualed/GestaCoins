package co.com.ceiba.adn.application.command;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BonificacionCommand {
	private long idBonificacion;
	private String codigoBonificacion;
	private String nombreBonificacion;
	private long valorBonificacion;
	private int tipoBonificacion;

	public long getIdBonificacion() {
		return idBonificacion;
	}

	public void setIdBonificacion(long idBonificacion) {
		this.idBonificacion = idBonificacion;
	}

	public String getCodigoBonificacion() {
		return codigoBonificacion;
	}

	public void setCodigoBonificacion(String codigoBonificacion) {
		this.codigoBonificacion = codigoBonificacion;
	}

	public String getNombreBonificacion() {
		return nombreBonificacion;
	}

	public void setNombreBonificacion(String nombreBonificacion) {
		this.nombreBonificacion = nombreBonificacion;
	}

	public long getValorBonificacion() {
		return valorBonificacion;
	}

	public void setValorBonificacion(long valorBonificacion) {
		this.valorBonificacion = valorBonificacion;
	}

	public int getTipoBonificacion() {
		return tipoBonificacion;
	}

	public void setTipoBonificacion(int tipoBonificacion) {
		this.tipoBonificacion = tipoBonificacion;
	}


	
}
