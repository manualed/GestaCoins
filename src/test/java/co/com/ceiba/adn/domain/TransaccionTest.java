package co.com.ceiba.adn.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import co.com.ceiba.adn.BasePrueba;
import co.com.ceiba.adn.builder.BonificacionTestDataBuilder;
import co.com.ceiba.adn.builder.EmpleadoTestDataBuilder;
import co.com.ceiba.adn.builder.TransaccionTestDataBuilder;
import co.com.ceiba.adn.domain.exception.RequiredValueException;
import co.com.ceiba.adn.domain.exception.ValidValueException;
import co.com.ceiba.adn.domain.model.entity.Transaccion;


class TransaccionTest {
	//id numeric, idEmpleado numeric, idBonificacion numeric, redimido boolean, fechaObtencion date, fechaRedencion date
	
	private static final String EMPLEADO_OBLIGATORIO = "El empleado es obligatorio.";
	private static final String BONIFICACION_OBLIGATORIO = "La bonificacion es obligatoria.";
	private static final String REDIMIDO_OBLIGATORIO = "El campo redimido es obligatorio.";
	private static final String FECHA_OBTENCION_OBLIGATORIO = "La fecha de obtencion es obligatoria.";	
	
	private static final String VALOR_IDBONIFICACION_DEBE_SER_MAYOR_A = "El id de la bonificacion debe ser mayor que %s";
	private static final String VALOR_IDEMPLEADO_DEBE_SER_MAYOR_A = "El id de la bonificacion debe ser mayor que %s";
	
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
	
	@Test
	public void validarTipoDocumentoObligatorio() {
		//Arrange
		TransaccionTestDataBuilder transaccionTestDataBuilder = new TransaccionTestDataBuilder();
		transaccionTestDataBuilder.conFechaObtencion(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> transaccionTestDataBuilder.build(), RequiredValueException.class, FECHA_OBTENCION_OBLIGATORIO);
	}
	
	@Test
	public void validarIdBonificacionObligatorio() {
		// Arrange
		TransaccionTestDataBuilder transaccionTestDataBuilder = new TransaccionTestDataBuilder();
		transaccionTestDataBuilder.conIdBonificacion(-12L);
		// Act - Assert
		BasePrueba.assertThrows(() -> transaccionTestDataBuilder.build(), ValidValueException.class,
				VALOR_IDBONIFICACION_DEBE_SER_MAYOR_A);
	}
	
	@Test
	public void validarIdEmpleadoObligatorio() {
		// Arrange
		TransaccionTestDataBuilder transaccionTestDataBuilder = new TransaccionTestDataBuilder();
		transaccionTestDataBuilder.conIdEmpleado(-2L);
		// Act - Assert
		BasePrueba.assertThrows(() -> transaccionTestDataBuilder.build(), ValidValueException.class,
				VALOR_IDEMPLEADO_DEBE_SER_MAYOR_A);
	}
}
