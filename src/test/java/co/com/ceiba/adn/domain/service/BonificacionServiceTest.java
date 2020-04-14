package co.com.ceiba.adn.domain.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import co.com.ceiba.adn.builder.BonificacionTestDataBuilder;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.port.repository.IBonificacionRepository;

public class BonificacionServiceTest {
	@Test
	public void validarCreacionBonificacion() {
		// Arrange
		Bonificacion bonificacion = new BonificacionTestDataBuilder().build();
		IBonificacionRepository bonificacionRepositoryMock = Mockito.mock(IBonificacionRepository.class);
		BonificacionService bonificacionService = new BonificacionService(bonificacionRepositoryMock);
		// Act
		bonificacionService.insertarBonificacion(bonificacion);
		// Assert
		assertNotNull(bonificacion.getCodigoBonificacion());
		assertNotNull(bonificacion.getIdBonificacion());
		assertNotNull(bonificacion.getNombreBonificacion());
		assertNotNull(bonificacion.getTipoBonificacion());
		assertNotNull(bonificacion.getValorBonificacion());
	}

	@Test
	public void listarBonificacion() {
		// Arrange
		List<Bonificacion> lista = new ArrayList<Bonificacion>();
		Bonificacion bonificacion = new BonificacionTestDataBuilder().build();
		lista.add(bonificacion);
		IBonificacionRepository bonificacionRepositoryMock = Mockito.mock(IBonificacionRepository.class);
		Mockito.when(bonificacionRepositoryMock.listar()).thenReturn(lista);
		BonificacionService bonificacionService = new BonificacionService(bonificacionRepositoryMock);
		// Act
		List<Bonificacion> listaBonificaciones = bonificacionService.listar();
		// Assert
		Assert.assertEquals(1, listaBonificaciones.size());
		Assert.assertEquals(listaBonificaciones.get(0).getCodigoBonificacion(), lista.get(0).getCodigoBonificacion());
	}

	@Test
	public void validarEliminarBonificacion() {
		// Arrange
		Bonificacion bonificacion = new BonificacionTestDataBuilder().build();
		IBonificacionRepository bonificacionRepositoryMock = Mockito.mock(IBonificacionRepository.class);
		BonificacionService bonificacionService = new BonificacionService(bonificacionRepositoryMock);
		// Act
		bonificacionService.eliminar(bonificacion.getIdBonificacion());
		// Assert
		verify(bonificacionRepositoryMock, times(1)).eliminar(bonificacion.getIdBonificacion());
	}

	@Test
	public void validarActualizarBonificacion() {
		// Arrange
		Bonificacion bonificacion = new BonificacionTestDataBuilder().build();
		Bonificacion bonificacionAux = new BonificacionTestDataBuilder().build();
		bonificacion.setCodigoBonificacion("102030");
		IBonificacionRepository bonificacionRepositoryMock = Mockito.mock(IBonificacionRepository.class);
		BonificacionService bonificacionService = new BonificacionService(bonificacionRepositoryMock);
		// Act
		bonificacionService.updateBonificacion(bonificacion);
		// Assert
		assertNotNull(bonificacion.getCodigoBonificacion());
		assertNotEquals(bonificacion.getCodigoBonificacion(), bonificacionAux.getCodigoBonificacion());

	}

//	@Test
//	public void validarObtenerBonificacion() {
//		// Arrange
//		Bonificacion bonificacion = new BonificacionTestDataBuilder().build();
//		IBonificacionRepository bonificacionRepositoryMock = Mockito.mock(IBonificacionRepository.class);
//		BonificacionService bonificacionService = new BonificacionService(bonificacionRepositoryMock);
//		// Act
//		Bonificacion bonificacionNew = bonificacionService.obtenerBonificacion(bonificacion.getIdBonificacion());
//		// Assert
//		assertNotNull(bonificacionNew.getCodigoBonificacion());
//
//	}

}
