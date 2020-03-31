package co.com.ceiba.adn.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import co.com.ceiba.adn.BasePrueba;
import co.com.ceiba.adn.builder.EmpleadoTestDataBuilder;
import co.com.ceiba.adn.domain.exception.RequiredValueException;
import co.com.ceiba.adn.domain.model.entity.Empleado;

class EmpleadoTest {
	private static final String TIPO_DOCUMENTO_OBLIGATORIO = "El tipo documento es obligatorio.";
	private static final String NUMERO_DOCUMENTO_OBLIGATORIO = "El numero de documento es obligatorio.";
	private static final String PRIMER_NOMBRE_OBLIGATORIO = "El primer nombre es obligatorio.";
	private static final String PRIMER_APELLIDO_OBLIGATORIO = "El primer apellido es obligatorio.";
	private static final String FECHA_INGRESO_OBLIGATORIO = "La fecha de ingreso es obligatoria.";	
	private static final String FECHA_NACIMIENTO_OBLIGATORIO = "La fecha de nacimiento es obligatoria.";	
	private static final String FECHA_CAMBIO_OBLIGATORIO = "La fecha del cambio del registro es obligatorio.";	
	private static final String EMAIL_OBLIGATORIO = "El email es obligatorio.";

	@Test
	public void validarCreacionEmpleado() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		//Act
		Empleado empleado = empleadoTestDataBuilder.build();
		// Assert
		Assert.assertNotNull(empleado);
		Assert.assertNotNull(empleado.getIdEmpleado());
		Assert.assertNotNull(empleado.getTipoDocumento());
		Assert.assertNotNull(empleado.getNumeroDocumento());
		Assert.assertNotNull(empleado.getPrimerNombre());
		Assert.assertNotNull(empleado.getPrimerApellido());
		Assert.assertNotNull(empleado.getFechaIngreso());
		Assert.assertNotNull(empleado.getFechaNacimiento());
		Assert.assertNotNull(empleado.getFechaCambio());
		Assert.assertNotNull(empleado.getEmail());
		
	}
	
	
	@Test
	public void validarTipoDocumentoObligatorio() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conTipoDocumento(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), RequiredValueException.class, TIPO_DOCUMENTO_OBLIGATORIO);
	}
	
	@Test
	public void validarNumeroDocumentoObligatorio() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conNumeroDocumento(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), RequiredValueException.class, NUMERO_DOCUMENTO_OBLIGATORIO);
	}
	
	@Test
	public void validarPrimerNombreObligatorio() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conPrimerNombre(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), RequiredValueException.class, PRIMER_NOMBRE_OBLIGATORIO);
	}
	@Test
	public void validarPrimerApellidoObligatorio() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conPrimerApellido(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), RequiredValueException.class, PRIMER_APELLIDO_OBLIGATORIO);
	}
	@Test
	public void validarFechaIngresoObligatorio() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conFechaIngreso(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), RequiredValueException.class, FECHA_INGRESO_OBLIGATORIO);
	}
	@Test
	public void validarFechaNacimientoObligatorio() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conFechaNacimiento(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), RequiredValueException.class, FECHA_NACIMIENTO_OBLIGATORIO);
	}
	@Test
	public void validarFechaCambioObligatorio() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conFechaCambio(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), RequiredValueException.class, FECHA_CAMBIO_OBLIGATORIO);
	}
	
	@Test
	public void validarEmailObligatorio() {
		//Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conEmail(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), RequiredValueException.class, EMAIL_OBLIGATORIO);
	}
}
