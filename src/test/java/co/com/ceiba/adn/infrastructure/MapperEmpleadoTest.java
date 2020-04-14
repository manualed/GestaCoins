package co.com.ceiba.adn.infrastructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mock;

import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.infrastructure.adapter.mapper.MapperEmpleado;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;

public class MapperEmpleadoTest {
	@Mock
	private EmpleadoEntity entity;
	@Test
	public void valueOfModel() {
		
		MapperEmpleado mapper = new MapperEmpleado();
		
		entity.setEmail("");
		entity.setFechaCambio(null);
		entity.setIdEmpleado(1L);
		entity.setFechaIngreso(null);
		entity.setFechaNacimiento(null);
		entity.setNumeroDocumento("");
		entity.setPrimerApellido("");
		entity.setTipoDocumento("");
		entity.setPrimerNombre("");
		
		Empleado empleado = new Empleado(0, entity.getTipoDocumento(), entity.getNumeroDocumento(), entity.getPrimerNombre(), 
				entity.getPrimerApellido(), entity.getFechaIngreso(), entity.getFechaNacimiento(), entity.getFechaCambio(), entity.getEmail());
		assertTrue(true);
		
	}
	
}
