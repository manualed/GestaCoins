package co.com.ceiba.adn.domain.model.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Generated
@Setter
@Getter
public class Bonificacion {

	private static final String ID_BONIFICACION_OBLIGATORIO = "La bonificacion es obligatoria.";
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

	private static final Long VALOR_NO_VALIDO_VALOR_BONIFICACION = 0L;
	private static final Long VALOR_NO_VALIDO_ID_BONIFICACION = 0L;
	private static final int MINIMO_TIPO_BONIFICACION = 0;
	private static final int MAXIMO_TIPO_BONIFICACION = 1;

	private long idBonificacion;
	private String codigoBonificacion;
	private String nombreBonificacion;
	private long valorBonificacion;
	private int tipoBonificacion;

	public Bonificacion(long idBonificacion, String codigoBonificacion, String nombreBonificacion,
			long valorBonificacion, int tipoBonificacion) {
		Validador.validarObligatoriedad(idBonificacion, ID_BONIFICACION_OBLIGATORIO);
		Validador.validarValorValido(idBonificacion, VALOR_NO_VALIDO_ID_BONIFICACION,
				VALOR_IDBONIFICACION_DEBE_SER_MAYOR_A);
		Validador.validarObligatoriedad(codigoBonificacion, CODIGO_BONIFICACION_OBLIGATORIO);
		Validador.validarObligatoriedad(nombreBonificacion, NOMBRE_BONIFICACION_OBLIGATORIO);
		Validador.validarRangoNoValido(valorBonificacion, VALOR_NO_VALIDO_VALOR_BONIFICACION,
				VALOR_BONIFICACION_OBLIGATORIO);
		Validador.validarRangoValido(tipoBonificacion, MINIMO_TIPO_BONIFICACION, MAXIMO_TIPO_BONIFICACION,
				String.format(TIPO_BONIFICACION_ENTRE, MINIMO_TIPO_BONIFICACION, MAXIMO_TIPO_BONIFICACION));
		Validador.validarMaxLenght(codigoBonificacion, TAMANO_MAXIMO_CODIGO,
				String.format(CODIGO_BONIFICACION_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_CODIGO));
		Validador.validarMinLenght(codigoBonificacion, TAMANO_MINIMO_CODIGO,
				String.format(CODIGO_BONIFICACION_DEBE_TENER_MINIMO, TAMANO_MINIMO_CODIGO));
		Validador.validarMaxLenght(nombreBonificacion, TAMANO_MAXIMO_NOMBRE,
				String.format(NOMBRE_BONIFICACION_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_NOMBRE));
		Validador.validarMinLenght(nombreBonificacion, TAMANO_MINIMO_NOMBRE,
				String.format(NOMBRE_BONIFICACION_DEBE_TENER_MINIMO, TAMANO_MINIMO_NOMBRE));

		this.idBonificacion = idBonificacion;
		this.codigoBonificacion = codigoBonificacion;
		this.nombreBonificacion = nombreBonificacion;
		this.valorBonificacion = valorBonificacion;
		this.tipoBonificacion = tipoBonificacion;
	}

}
