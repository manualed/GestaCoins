package co.com.ceiba.adn.infrastructure;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.application.driver.EmpleadoDriver;
import co.com.ceiba.adn.application.factory.EmpleadoFactory;
import co.com.ceiba.adn.builder.EmpleadoTestDataBuilder;
import co.com.ceiba.adn.databuilder.EmpleadoCommandTestDataBuilder;
import co.com.ceiba.adn.domain.exception.MaximumLenghtException;
import co.com.ceiba.adn.domain.exception.RequiredValueException;
import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.port.repository.IEmpleadoRepository;
import co.com.ceiba.adn.domain.service.EmpleadoService;
import co.com.ceiba.adn.infrastructure.controller.EmpleadoController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EmpleadoControllerTest {
	private static final String DOCUMENTO_DEBE_TENER_MAXIMO = "El documento debe tener maximo %s caracteres.";
	private static final int TAMANO_MAXIMO_DOCUMENTO = 50;
	@Autowired
	private MockMvc mockmvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext context;
	
	@BeforeEach
	public void setup() {
		this.mockmvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void crearEmpleado() throws Exception {
		// Arrange
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conFechaIngreso(new Calendar.Builder().setDate(2012, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conEmail("manu.ginobili@ceiba.com.co");
		empleadoCommandTestDataBuilder.conFechaCambio(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		empleadoCommandTestDataBuilder.conFechaNacimiento(new Calendar.Builder().setDate(2000, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conNumeroDocumento("883839289");
		empleadoCommandTestDataBuilder.conTipoDocumento("CE");
		empleadoCommandTestDataBuilder.conPrimerApellido("GINOBILI");
		empleadoCommandTestDataBuilder.conPrimerNombre("MANUEL");
		empleadoCommandTestDataBuilder.conIdEmpleado(2);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();

		// Act - Assert
		this.mockmvc.perform(post("/api/coins/empleado")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(empleadoCommand)))
				.andExpect(status().isOk());

	}

	@Test
	public void crearConDatosNulos() throws Exception {
		// Arrange
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conFechaIngreso(new Calendar.Builder().setDate(2012, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conNumeroDocumento(null);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();

		// Act - Assert
		this.mockmvc
				.perform(post("/api/coins/empleado").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(empleadoCommand)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.excepcion").value(RequiredValueException.class.getSimpleName()));

	}

	@Test
	public void crearConCedulaDeLongitudMaxima() throws Exception {
		// Arrange
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conFechaIngreso(new Calendar.Builder().setDate(2012, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder
				.conNumeroDocumento("98475983479387459384759028347598324752938457902384759032485798345");
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		// Act - Assert
		this.mockmvc
				.perform(post("/api/coins/empleado").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(empleadoCommand)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.excepcion").value(MaximumLenghtException.class.getSimpleName()))
				.andExpect(jsonPath("$.mensaje")
						.value(String.format(DOCUMENTO_DEBE_TENER_MAXIMO, TAMANO_MAXIMO_DOCUMENTO)));
	}

	@Test
	public void listaEmpleadosOk() throws Exception {
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		String uri = "/api/coins/empleados";
		this.mockmvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(empleadoCommand))).andExpect(status().isOk());

	}

	@Test
	public void validarEliminarEmpleado() throws Exception {
		// Arrange
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conFechaIngreso(new Calendar.Builder().setDate(2012, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conEmail("manu.ginobili@ceiba.com.co");
		empleadoCommandTestDataBuilder.conFechaCambio(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		empleadoCommandTestDataBuilder.conFechaNacimiento(new Calendar.Builder().setDate(2000, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conNumeroDocumento("883839289");
		empleadoCommandTestDataBuilder.conTipoDocumento("CE");
		empleadoCommandTestDataBuilder.conPrimerApellido("GINOBILI");
		empleadoCommandTestDataBuilder.conPrimerNombre("MANUEL");
		empleadoCommandTestDataBuilder.conIdEmpleado(1L);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		String uri = "/api/coins/empleado";
		this.mockmvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(empleadoCommand))).andExpect(status().isOk());
		// Act - Assert
		this.mockmvc.perform(delete("/api/coins/empleados/{id}", empleadoCommand.getIdEmpleado()))
				.andExpect(status().isOk());
	}
	
	@Test
	public void obtenerEmpleadoOk() throws Exception {
		// Arrange
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conFechaIngreso(new Calendar.Builder().setDate(2012, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conEmail("juan.ginobili@ceiba.com.co");
		empleadoCommandTestDataBuilder.conFechaCambio(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		empleadoCommandTestDataBuilder.conFechaNacimiento(new Calendar.Builder().setDate(2000, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conNumeroDocumento("3333333");
		empleadoCommandTestDataBuilder.conTipoDocumento("CC");
		empleadoCommandTestDataBuilder.conPrimerApellido("GINOBILI");
		empleadoCommandTestDataBuilder.conPrimerNombre("JUAN");
		empleadoCommandTestDataBuilder.conIdEmpleado(1);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		this.mockmvc.perform(post("/api/coins/empleado")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(empleadoCommand)))
				.andExpect(status().isOk());
		
		// Act - Assert
		this.mockmvc.perform(get("/api/coins/empleado/{id}", empleadoCommand.getIdEmpleado())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(empleadoCommand))).andExpect(status().isOk());

	}
	

	@Test
	public void validarUpdateEmpleado() throws Exception {
		// Arrange
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conFechaIngreso(new Calendar.Builder().setDate(2012, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conEmail("manu.ginobili@ceiba.com.co");
		empleadoCommandTestDataBuilder.conFechaCambio(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		empleadoCommandTestDataBuilder.conFechaNacimiento(new Calendar.Builder().setDate(2000, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conNumeroDocumento("883839289");
		empleadoCommandTestDataBuilder.conTipoDocumento("CE");
		empleadoCommandTestDataBuilder.conPrimerApellido("GINOBILI");
		empleadoCommandTestDataBuilder.conPrimerNombre("MANUEL");
		empleadoCommandTestDataBuilder.conIdEmpleado(1L);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		this.mockmvc.perform(put("/api/coins/empleado/{id}", empleadoCommand.getIdEmpleado()).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(empleadoCommand))).andExpect(status().isOk());
	}
	
	@Test
	public void validarUpdateFailedEmpleado() throws Exception {
		// Arrange
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conFechaIngreso(new Calendar.Builder().setDate(2012, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conEmail("manu.ginobili@ceiba.com.co");
		empleadoCommandTestDataBuilder.conFechaCambio(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		empleadoCommandTestDataBuilder.conFechaNacimiento(new Calendar.Builder().setDate(2000, 6, 4).build().getTime());
		empleadoCommandTestDataBuilder.conNumeroDocumento(null);
		empleadoCommandTestDataBuilder.conTipoDocumento("CE");
		empleadoCommandTestDataBuilder.conPrimerApellido("GINOBILI");
		empleadoCommandTestDataBuilder.conPrimerNombre("MANUEL");
		empleadoCommandTestDataBuilder.conIdEmpleado(1L);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		this.mockmvc.perform(put("/api/coins/empleado/{id}", empleadoCommand.getIdEmpleado())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(empleadoCommand)))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldObtainEmpleado() {
		IEmpleadoRepository empleadoRepositoryMock = Mockito.mock(IEmpleadoRepository.class);
		EmpleadoService empleadoService = new EmpleadoService(empleadoRepositoryMock);
		EmpleadoFactory empleadoFactory = new EmpleadoFactory();
		EmpleadoDriver empleadoDriver = new EmpleadoDriver(empleadoService,empleadoFactory);
		EmpleadoController bonificacionController = new EmpleadoController(empleadoDriver);
		Empleado empleado = new EmpleadoTestDataBuilder().build();
		long id = 1L;
		bonificacionController.obtenerEmpleado(id);
		assertNotNull(empleado);
	}

}
