package co.com.ceiba.adn.domain.model.entity;

public class Bonificacion {

	private long idBonificacion;
	private String codigoBonificacion;
	private String nombreBonificacion;
	private long valorBonificacion;
	private int tipoBonificacion;
	
	public Bonificacion(long idBonificacion, String codigoBonificacion, String nombreBonificacion, long valorBonificacion,
			int tipoBonificacion) {
		this.idBonificacion = idBonificacion;
		this.codigoBonificacion = codigoBonificacion;
		this.nombreBonificacion = nombreBonificacion;
		this.valorBonificacion = valorBonificacion;
		this.tipoBonificacion = tipoBonificacion;
	}
	
	
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
