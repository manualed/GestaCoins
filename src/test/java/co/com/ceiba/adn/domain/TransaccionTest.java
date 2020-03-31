package co.com.ceiba.adn.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import co.com.ceiba.adn.builder.TransaccionTestDataBuilder;
import co.com.ceiba.adn.domain.model.entity.Transaccion;


class TransaccionTest {
	private static final String EMPLEADO_OBLIGATORIO = "El empleado es obligatorio.";
	private static final String BONIFICACION_OBLIGATORIO = "La bonificacion es obligatoria.";
	private static final String REDIMIDO_OBLIGATORIO = "El campo redimido es obligatorio.";
	private static final String FECHA_OBTENCION_OBLIGATORIO = "La fecha de obtencion es obligatoria.";	
	
	@Test
	public void validarCreacionTransaccion() {
		//Arrange
		TransaccionTestDataBuilder transaccionTestDataBuilder = new TransaccionTestDataBuilder();
		//Act
		Transaccion transaccion = transaccionTestDataBuilder.build();
		// Assert
		Assert.assertNotNull(transaccion);
		Assert.assertNotNull(transaccion.getIdBonificacion());
		Assert.assertNotNull(transaccion.getIdEmpleado());
		Assert.assertNotNull(transaccion.getFechaObtencion());
		Assert.assertNotNull(transaccion.getFechaRedencion());
		
	}
}
