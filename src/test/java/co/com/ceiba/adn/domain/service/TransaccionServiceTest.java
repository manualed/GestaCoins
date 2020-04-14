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

import co.com.ceiba.adn.builder.TransaccionTestDataBuilder;
import co.com.ceiba.adn.domain.model.entity.Transaccion;
import co.com.ceiba.adn.domain.port.repository.ITransaccionRepository;

public class TransaccionServiceTest {

	@Test
    public void validarCreacionTransaccion(){
		//Arrange
		Transaccion transaccion = new TransaccionTestDataBuilder().build();
		ITransaccionRepository transaccionRepositoryMock = Mockito.mock(ITransaccionRepository.class);
		TransaccionService empleadoService = new TransaccionService(transaccionRepositoryMock);
        //Act
        empleadoService.insertarTransaccion(transaccion);
        //Assert
        assertNotNull(transaccion.getFechaObtencion());
        assertNotNull(transaccion.getFechaRedencion());
        assertNotNull(transaccion.getIdBonificacion());
        assertNotNull(transaccion.getIdEmpleado());
        assertNotNull(transaccion.getBonificacion());
        assertNotNull(transaccion.getEmpleado());
    }
	
	@Test
	public void listarTransaccion() {
		// Arrange
		List<Transaccion> lista = new ArrayList<Transaccion>();
		Transaccion transaccion = new TransaccionTestDataBuilder().build();
		lista.add(transaccion);
		ITransaccionRepository transaccionRepositoryMock = Mockito.mock(ITransaccionRepository.class);
		Mockito.when(transaccionRepositoryMock.listar()).thenReturn(lista);
		TransaccionService transaccionService = new TransaccionService(transaccionRepositoryMock);
		// Act
		List<Transaccion> listaTransaccion = transaccionService.listar();
		// Assert
		Assert.assertEquals(1, listaTransaccion.size());
		Assert.assertEquals(listaTransaccion.get(0).getIdTransaccion(), lista.get(0).getIdTransaccion());
	}
	
	@Test
	public void validarEliminarTransaccion(){
		//Arrange
		Transaccion transaccion = new TransaccionTestDataBuilder().build();
		ITransaccionRepository transaccionRepositoryMock = Mockito.mock(ITransaccionRepository.class);
		TransaccionService transaccionService = new TransaccionService(transaccionRepositoryMock);
		//Act
		transaccionService.eliminar(transaccion.getIdTransaccion());
		//Assert
		verify(transaccionRepositoryMock, times(1)).eliminar(transaccion.getIdTransaccion());
	}
	
	@Test
    public void validarActualizarEmpleado(){
		//Arrange
		Transaccion transaccion = new TransaccionTestDataBuilder().build();
		Transaccion transaccionAux = new TransaccionTestDataBuilder().build();
		transaccion.setRedimido(false);

		ITransaccionRepository transaccionRepositoryMock = Mockito.mock(ITransaccionRepository.class);
		TransaccionService transaccionService = new TransaccionService(transaccionRepositoryMock);
        //Act
		transaccionService.updateTransaccion(transaccion);
        //Assert
        assertNotNull(transaccion.isRedimido());
        assertNotEquals(transaccion.isRedimido(),transaccionAux.isRedimido());
        
    }
}
