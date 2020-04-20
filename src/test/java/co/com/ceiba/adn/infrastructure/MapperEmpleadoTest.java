package co.com.ceiba.adn.infrastructure;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
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
		
		entity = new EmpleadoEntity ();
		entity.setEmail("correo@correo.dot");
		entity.setFechaCambio(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		entity.setIdEmpleado(1L);
		entity.setFechaIngreso(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		entity.setFechaNacimiento(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		entity.setNumeroDocumento("34535435");
		entity.setPrimerApellido("afrino");
		entity.setTipoDocumento("CC");
		entity.setPrimerNombre("caprino");
		
		Empleado empleado = new Empleado(0, entity.getTipoDocumento(), entity.getNumeroDocumento(), entity.getPrimerNombre(), 
				entity.getPrimerApellido(), entity.getFechaIngreso(), entity.getFechaNacimiento(), entity.getFechaCambio(), entity.getEmail());
		assertNotNull(empleado);
		
	}
	
}
