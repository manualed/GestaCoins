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

import co.com.ceiba.adn.builder.EmpleadoTestDataBuilder;
import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.port.repository.IEmpleadoRepository;

public class EmpleadoServiceTest {

	@Test
    public void validarCreacionEmpleado(){
		//Arrange
		Empleado empleado = new EmpleadoTestDataBuilder().build();
		IEmpleadoRepository empleadorepositoryMock = Mockito.mock(IEmpleadoRepository.class);
        EmpleadoService empleadoService = new EmpleadoService(empleadorepositoryMock);
        //Act
        empleadoService.insertarEmpleado(empleado);
        //Assert
        assertNotNull(empleado.getPrimerNombre());
        assertNotNull(empleado.getPrimerApellido());
        assertNotNull(empleado.getEmail());
    }
	
	@Test
	public void listarEmpleados() {
		// Arrange
		List<Empleado> lista = new ArrayList<Empleado>();
		Empleado empleado = new EmpleadoTestDataBuilder().build();
		lista.add(empleado);
		IEmpleadoRepository empleadoRepositoryMock = Mockito.mock(IEmpleadoRepository.class);
		Mockito.when(empleadoRepositoryMock.listar()).thenReturn(lista);
		EmpleadoService empleadoService = new EmpleadoService(empleadoRepositoryMock);
		// Act
		List<Empleado> listaEmpleado = empleadoService.listar();
		// Assert
		Assert.assertEquals(1, listaEmpleado.size());
		Assert.assertEquals(listaEmpleado.get(0).getIdEmpleado(), lista.get(0).getIdEmpleado());
	}
	
	@Test
	public void validarEliminarEmpleado(){
		//Arrange
		Empleado empleado = new EmpleadoTestDataBuilder().build();
		IEmpleadoRepository empleadoRepositoryMock = Mockito.mock(IEmpleadoRepository.class);
		EmpleadoService empleadoService = new EmpleadoService(empleadoRepositoryMock);
		//Act
		empleadoService.eliminar(empleado.getIdEmpleado());
		//Assert
		verify(empleadoRepositoryMock, times(1)).eliminar(empleado.getIdEmpleado());
	}
	
	@Test
    public void validarActualizarEmpleado(){
		//Arrange
		Empleado empleado = new EmpleadoTestDataBuilder().build();
		Empleado empleadoAux = new EmpleadoTestDataBuilder().build();
		empleado.setPrimerNombre("ANTON");
		IEmpleadoRepository empleadoRepositoryMock = Mockito.mock(IEmpleadoRepository.class);
		EmpleadoService empleadoService = new EmpleadoService(empleadoRepositoryMock);
        //Act
		empleadoService.updateEmpleado(empleado);
        //Assert
        assertNotNull(empleado.getPrimerNombre());
        assertNotEquals(empleado.getPrimerNombre(),empleadoAux.getPrimerNombre());
        
    }
}
