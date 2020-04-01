package co.com.ceiba.adn.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import co.com.ceiba.adn.BasePrueba;
import co.com.ceiba.adn.builder.EmpleadoTestDataBuilder;
import co.com.ceiba.adn.domain.exception.MaximumLenghtException;
import co.com.ceiba.adn.domain.exception.MinimumLenghtException;
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
	
	private static final String DOCUMENTO_DEBE_TENER_MAXIMO = "El documento debe tener maximo %s caracteres.";
	private static final String DOCUMENTO_DEBE_TENER_MINIMO = "El documento debe tener minimo %s caracteres.";
	private static final String NOMBRE_DEBE_TENER_MAXIMO = "El nombre debe tener maximo %s caracteres.";
	private static final String NOMBRE_DEBE_TENER_MINIMO = "El nombre debe tener minimo %s caracteres.";
	private static final String APELLIDO_DEBE_TENER_MAXIMO = "El apellido debe tener maximo %s caracteres.";
	private static final String APELLIDO_DEBE_TENER_MINIMO = "El apellido debe tener minimo %s caracteres.";
	private static final String EMAIL_DEBE_TENER_MAXIMO = "El email debe tener maximo %s caracteres.";
	private static final String EMAIL_DEBE_TENER_MINIMO = "El email debe tener minimo %s caracteres.";
	
	private static final int TAMANO_MAXIMO_DOCUMENTO = 50;
	private static final int TAMANO_MINIMO_DOCUMENTO = 3;
	private static final int TAMANO_MAXIMO_NOMBRE = 50;
	private static final int TAMANO_MINIMO_NOMBRE = 1;
	private static final int TAMANO_MAXIMO_APELLIDO = 50;
	private static final int TAMANO_MINIMO_APELLIDO = 1;
	private static final int TAMANO_MAXIMO_EMAIL = 50;
	private static final int TAMANO_MINIMO_EMAIL = 1;

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
	
	@Test
	public void validarMaximoTamanoDocumentoEmpleado() {
		// Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conNumeroDocumento("98475983479387459384759028347598324752938457902384759032485798345");
		// Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), MaximumLenghtException.class,
				String.format(DOCUMENTO_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_DOCUMENTO));
	}

	@Test
	public void validarMinimoTamanoDocumentoEmpleado() {
		// Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conNumeroDocumento("223");
		// Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), MinimumLenghtException.class,
				String.format(DOCUMENTO_DEBE_TENER_MINIMO, TAMANO_MINIMO_DOCUMENTO));
	}
	
	@Test
	public void validarMaximoTamanoNombreEmpleado() {
		// Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conPrimerNombre("Brhadaranyakopanishadvivekachudamani Erreh Erreh Erreh");
		// Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), MaximumLenghtException.class,
				String.format(NOMBRE_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_NOMBRE));
	}

	@Test
	public void validarMinimoTamanoNombreEmpleado() {
		// Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conPrimerNombre("A");
		// Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), MinimumLenghtException.class,
				String.format(NOMBRE_DEBE_TENER_MINIMO, TAMANO_MINIMO_NOMBRE));
	}
	
	@Test
	public void validarMaximoTamanoApellidoEmpleado() {
		// Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conPrimerApellido("Iturriberrigorrigoicoerrotaberricoecheaoecheaecheaechea");
		// Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), MaximumLenghtException.class,
				String.format(APELLIDO_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_APELLIDO));
	}

	@Test
	public void validarMinimoTamanoApellidoEmpleado() {
		// Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conPrimerApellido("A");
		// Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), MinimumLenghtException.class,
				String.format(APELLIDO_DEBE_TENER_MINIMO, TAMANO_MINIMO_APELLIDO));
	}
	
	@Test
	public void validarMaximoTamanoEmailEmpleado() {
		// Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conEmail("0xLJB3F6C4C9D3EBCFD6BDF0B9DCC0EDzFJPJKFBCNYXJGL@mail.notes.bank-of-china.com");
		// Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), MaximumLenghtException.class,
				String.format(EMAIL_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_EMAIL));
	}

	@Test
	public void validarMinimoTamanoEmailEmpleado() {
		// Arrange
		EmpleadoTestDataBuilder empleadoTestDataBuilder = new EmpleadoTestDataBuilder();
		empleadoTestDataBuilder.conEmail("A");
		// Act - Assert
		BasePrueba.assertThrows(() -> empleadoTestDataBuilder.build(), MinimumLenghtException.class,
				String.format(EMAIL_DEBE_TENER_MINIMO, TAMANO_MINIMO_EMAIL));
	}
	
}
