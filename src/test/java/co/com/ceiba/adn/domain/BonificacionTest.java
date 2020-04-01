package co.com.ceiba.adn.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import co.com.ceiba.adn.BasePrueba;
import co.com.ceiba.adn.builder.BonificacionTestDataBuilder;
import co.com.ceiba.adn.domain.exception.MaximumLenghtException;
import co.com.ceiba.adn.domain.exception.MinimumLenghtException;
import co.com.ceiba.adn.domain.exception.RangeException;
import co.com.ceiba.adn.domain.exception.RequiredValueException;
import co.com.ceiba.adn.domain.exception.ValidValueException;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;

class BonificacionTest {

	private static final String CODIGO_BONIFICACION_OBLIGATORIO = "El codigo de bonificacion es obligatorio.";
	private static final String NOMBRE_BONIFICACION_OBLIGATORIO = "El nombre de la bonificacion es obligatorio.";
	private static final String VALOR_BONIFICACION_OBLIGATORIO = "El valor de la bonificacion es obligatoria.";
	private static final String VALOR_IDBONIFICACION_DEBE_SER_MAYOR_A = "El id de la bonificacion debe ser mayor que %s";
	private static final String CODIGO_BONIFICACION_DEBE_TENER_MAXIMO = "El codigo de bonificacion debe tener maximo %s caracteres.";
	private static final String CODIGO_BONIFICACION_DEBE_TENER_MINIMO = "El codigo de bonificacion debe tener minimo %s caracteres.";

	private static final String NOMBRE_BONIFICACION_DEBE_TENER_MAXIMO = "El nombre de bonificacion debe tener maximo %s caracteres.";
	private static final String NOMBRE_BONIFICACION_DEBE_TENER_MINIMO = "El nombre de bonificacion debe tener minimo %s caracteres.";

	private static final String TIPO_BONIFICACION_ENTRE = "El tipo de bonificacion debe estar entre %s y %s";

	private static final int TAMANO_MAXIMO_CODIGO = 10;
	private static final int TAMANO_MINIMO_CODIGO = 3;
	private static final int TAMANO_MAXIMO_NOMBRE = 100;
	private static final int TAMANO_MINIMO_NOMBRE = 3;

	private static final int MINIMO_TIPO_BONIFICACION = 0;
	private static final int MAXIMO_TIPO_BONIFICACION = 1;

	@Test
	public void validarCreacionBonificacion() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		// Act
		Bonificacion bonificacion = bonificacionTestDataBuilder.build();
		// Assert
		Assert.assertNotNull(bonificacion);
		Assert.assertNotNull(bonificacion.getIdBonificacion());
		Assert.assertNotNull(bonificacion.getCodigoBonificacion());
		Assert.assertNotNull(bonificacion.getNombreBonificacion());
		Assert.assertNotNull(bonificacion.getValorBonificacion());
		Assert.assertNotNull(bonificacion.getTipoBonificacion());

	}

	@Test
	public void validarIdBonificacionObligatorio() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conIdBonificacion(-12L);
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), ValidValueException.class,
				VALOR_IDBONIFICACION_DEBE_SER_MAYOR_A);
	}

	@Test
	public void validarCodigoBonificacionObligatorio() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conCodigoBonificacion(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), RequiredValueException.class,
				CODIGO_BONIFICACION_OBLIGATORIO);
	}

	@Test
	public void validarMaximoTamanoCodigoBonificacion() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conCodigoBonificacion("BONO10000000");
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), MaximumLenghtException.class,
				String.format(CODIGO_BONIFICACION_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_CODIGO));
	}

	@Test
	public void validarMinimoTamanoCodigoBonificacion() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conCodigoBonificacion("BON");
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), MinimumLenghtException.class,
				String.format(CODIGO_BONIFICACION_DEBE_TENER_MINIMO, TAMANO_MINIMO_CODIGO));
	}

	@Test
	public void validarNombreBonificacionObligatorio() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conNombreBonificacion(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), RequiredValueException.class,
				NOMBRE_BONIFICACION_OBLIGATORIO);
	}

	@Test
	public void validarMaximoTamanoNombreBonificacion() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conNombreBonificacion(
				"Taumatawhakatangihangak oauauotamateaturipukaka pikimaungahoronukupokaiwhe nua kitanatahu - Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch");
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), MaximumLenghtException.class,
				String.format(NOMBRE_BONIFICACION_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_NOMBRE));
	}

	@Test
	public void validarMinimoTamanoNombreBonificacion() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conNombreBonificacion("AUX");
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), MinimumLenghtException.class,
				String.format(NOMBRE_BONIFICACION_DEBE_TENER_MINIMO, TAMANO_MINIMO_NOMBRE));
	}

	@Test
	public void validarValorBonificacionObligatorio() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conValorBonificacion(0);
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), RangeException.class,
				VALOR_BONIFICACION_OBLIGATORIO);
	}

	@Test
	public void validarTipoBonificacionObligatorio() {
		// Arrange
		BonificacionTestDataBuilder bonificacionTestDataBuilder = new BonificacionTestDataBuilder();
		bonificacionTestDataBuilder.conTipoBonificacion(-1);
		// Act - Assert
		BasePrueba.assertThrows(() -> bonificacionTestDataBuilder.build(), RangeException.class,
				String.format(TIPO_BONIFICACION_ENTRE, MINIMO_TIPO_BONIFICACION, MAXIMO_TIPO_BONIFICACION));
	}
}
