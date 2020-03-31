package co.com.ceiba.adn.builder;

import co.com.ceiba.adn.domain.model.Bonificacion;

public class BonificacionTestDataBuilder {

	private long idBonificacion;
	private String codigoBonificacion;
	private String nombreBonificacion;
	private long valorBonificacion;
	private int tipoBonificacion;
	
	public BonificacionTestDataBuilder() {
		this.idBonificacion = 1;
		this.codigoBonificacion = "0001";
		this.nombreBonificacion = "BONO INGRESO";
		this.valorBonificacion = 100000L;
		this.tipoBonificacion = 1;
	}
	public BonificacionTestDataBuilder conIdBonificacion(long idBonificacion) {
		this.idBonificacion = idBonificacion;
		return this;
	}
	public BonificacionTestDataBuilder conCodigoBonificacion(String codigoBonificacion) {
		this.codigoBonificacion = codigoBonificacion;
		return this;
	}
	public BonificacionTestDataBuilder conNombreBonificacion(String nombreBonificacion) {
		this.nombreBonificacion = nombreBonificacion;
		return this;
	}
	public BonificacionTestDataBuilder conValorBonificacion(long valorBonificacion) {
		this.valorBonificacion = valorBonificacion;
		return this;
	}
	public BonificacionTestDataBuilder conTipoBonificacion(int tipoBonificacion) {
		this.tipoBonificacion = tipoBonificacion;
		return this;
	}
	
	public Bonificacion build() {
		return new Bonificacion(idBonificacion,  codigoBonificacion,  nombreBonificacion,  valorBonificacion, tipoBonificacion);
	}
	
	public static BonificacionTestDataBuilder unaBonificacion(){
        return new BonificacionTestDataBuilder();
    }
	
}
