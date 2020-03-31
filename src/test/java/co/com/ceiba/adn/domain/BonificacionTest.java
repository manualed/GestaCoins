package co.com.ceiba.adn.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import co.com.ceiba.adn.builder.BonificacionTestDataBuilder;
import co.com.ceiba.adn.builder.TransaccionTestDataBuilder;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.model.entity.Transaccion;

class BonificacionTest {
	
	private static final String ID_BONIFICACION_OBLIGATORIO = "La bonificacion es obligatoria.";
	private static final String CODIGO_BONIFICACION_OBLIGATORIO = "El codigo de bonificacion es obligatorio.";
	private static final String NOMBRE_BONIFICACION_OBLIGATORIO = "El nombre de la bonificacion es obligatorio.";
	private static final String VALOR_BONIFICACION_OBLIGATORIO = "El valor de la bonificacion es obligatoria.";	
	private static final String TIPO_BONIFICACION_OBLIGATORIO = "El tipo de la bonificacion es obligatoria.";	
	
	@Test
	public void validarCreacionBonificacion() {
		//Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		//Act
		Bonificacion bonificacion = bonificacionTestDataBuilder.build();
		// Assert
		Assert.assertNotNull(bonificacion);
		Assert.assertNotNull(bonificacion.getIdBonificacion());
		Assert.assertNotNull(bonificacion.getCodigoBonificacion());
		Assert.assertNotNull(bonificacion.getNombreBonificacion());
		Assert.assertNotNull(bonificacion.getValorBonificacion());
		Assert.assertNotNull(bonificacion.getTipoBonificacion());
		
		
	}
}
