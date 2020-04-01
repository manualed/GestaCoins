package co.com.ceiba.adn.application;

import co.com.ceiba.adn.application.command.BonificacionCommand;

public class BonificacionCommandTestDataBuilder {
	private long idBonificacion;
	private String codigoBonificacion;
	private String nombreBonificacion;
	private long valorBonificacion;
	private int tipoBonificacion;

	public BonificacionCommandTestDataBuilder() {
		this.codigoBonificacion = "103020";
		this.nombreBonificacion = "BONO CUMPLE";
		this.valorBonificacion = 150000L;
		this.tipoBonificacion = 1;
	}
	
	public BonificacionCommandTestDataBuilder conIdBonificacion(long idBonificacion) {
		this.idBonificacion = idBonificacion;
		return this;
	}
	public BonificacionCommandTestDataBuilder conIdBonificacionNoValida(long idBonificacion) {
		this.idBonificacion = idBonificacion;
		return this;
	}
	public BonificacionCommandTestDataBuilder conCodigoBonificacion(String codigoBonificacion) {
		this.codigoBonificacion = codigoBonificacion;
		return this;
	}
	public BonificacionCommandTestDataBuilder conNombreBonificacion(String nombreBonificacion) {
		this.nombreBonificacion = nombreBonificacion;
		return this;
	}
	public BonificacionCommandTestDataBuilder conValorBonificacion(long valorBonificacion) {
		this.valorBonificacion = valorBonificacion;
		return this;
	}
	public BonificacionCommandTestDataBuilder conTipoBonificacion(int tipoBonificacion) {
		this.tipoBonificacion = tipoBonificacion;
		return this;
	}
	
	public BonificacionCommand build() {
		return new BonificacionCommand(idBonificacion,  codigoBonificacion,  nombreBonificacion,  valorBonificacion, tipoBonificacion);
	}
}
