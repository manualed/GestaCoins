package co.com.ceiba.adn.infrastructure;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.adn.CoinsApplication;
import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.application.command.TransaccionCommand;
import co.com.ceiba.adn.databuilder.BonificacionCommandTestDataBuilder;
import co.com.ceiba.adn.databuilder.EmpleadoCommandTestDataBuilder;
import co.com.ceiba.adn.databuilder.TransaccionCommandTestDataBuilder;
import co.com.ceiba.adn.domain.exception.RequiredValueException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CoinsApplication.class })
@AutoConfigureMockMvc
@Transactional
public class TransactionControllerTest {
	@Autowired
	private MockMvc mockmvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		this.mockmvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void crearTransaccionConDatosNulos() throws Exception {
		// Arrange
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		transaccionCommandTestDataBuilder.conFechaObtencion(null);
		transaccionCommandTestDataBuilder.conFechaRedencion(null);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();

		// Act - Assert
		this.mockmvc
				.perform(post("/api/coins/empleado").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(transaccionCommand)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.excepcion").value(RequiredValueException.class.getSimpleName()));

	}

	@Test
	public void listaTransaccionOk() throws Exception {
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();
		String uri = "/api/coins/transacciones";
		this.mockmvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(transaccionCommand))).andExpect(status().isOk());

	}

	@Test
	public void validarUpdateFailedTransaccion() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conIdBonificacion(2);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conIdEmpleado(2);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		transaccionCommandTestDataBuilder.esRedimido(false);
		transaccionCommandTestDataBuilder.conFechaObtencion(null);
		transaccionCommandTestDataBuilder.conFechaRedencion(null);
		transaccionCommandTestDataBuilder.conIdBonificacion(2);
		transaccionCommandTestDataBuilder.conIdEmpleado(2);
		transaccionCommandTestDataBuilder.conIdTransaccion(1);
		transaccionCommandTestDataBuilder.conBonificacionCommand(bonificacionCommand);
		transaccionCommandTestDataBuilder.conEmpleadoCommand(empleadoCommand);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();
		this.mockmvc.perform(put("/api/coins/transaccion/{id}", transaccionCommand.getIdEmpleado())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(transaccionCommand)))
				.andExpect(status().isBadRequest());
	}


	@Test
	public void crearTransaccion() throws Exception {

		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conIdBonificacion(1);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conIdEmpleado(1);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		transaccionCommandTestDataBuilder.esRedimido(false);
		transaccionCommandTestDataBuilder
				.conFechaObtencion(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		transaccionCommandTestDataBuilder
				.conFechaRedencion(new Calendar.Builder().setDate(2020, 9, 1).build().getTime());
		transaccionCommandTestDataBuilder.conIdBonificacion(1);
		transaccionCommandTestDataBuilder.conIdEmpleado(1);
		transaccionCommandTestDataBuilder.conIdTransaccion(1);
		transaccionCommandTestDataBuilder.conBonificacionCommand(bonificacionCommand);
		transaccionCommandTestDataBuilder.conEmpleadoCommand(empleadoCommand);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();

		// Act - Assert

		this.mockmvc
				.perform(post("/api/coins/empleado").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(empleadoCommand)))
				.andDo(print()).andExpect(status().isOk());
		this.mockmvc
				.perform(post("/api/coins/bonificacion").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(bonificacionCommand)))
				.andDo(print()).andExpect(status().isOk());
		this.mockmvc
				.perform(post("/api/coins/transaccion").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(transaccionCommand)))
				.andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void validarUpdateTransaccion() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conIdEmpleado(1);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		transaccionCommandTestDataBuilder.esRedimido(false);
		transaccionCommandTestDataBuilder
				.conFechaObtencion(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		transaccionCommandTestDataBuilder
				.conFechaRedencion(new Calendar.Builder().setDate(2020, 9, 1).build().getTime());
		transaccionCommandTestDataBuilder.conIdEmpleado(1);
		transaccionCommandTestDataBuilder.conIdTransaccion(1);
		transaccionCommandTestDataBuilder.conBonificacionCommand(bonificacionCommand);
		transaccionCommandTestDataBuilder.conEmpleadoCommand(empleadoCommand);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();
		mockmvc.perform(put("/api/coins/transaccion/{id}", transaccionCommand.getIdEmpleado())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(transaccionCommand)))
				.andExpect(status().isOk());
	}

	@Test
	public void validarEliminarTransaccion() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conIdBonificacion(2);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conIdEmpleado(2);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		transaccionCommandTestDataBuilder.esRedimido(false);
		transaccionCommandTestDataBuilder
				.conFechaObtencion(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		transaccionCommandTestDataBuilder
				.conFechaRedencion(new Calendar.Builder().setDate(2020, 9, 1).build().getTime());
		transaccionCommandTestDataBuilder.conIdBonificacion(2);
		transaccionCommandTestDataBuilder.conIdEmpleado(2);
		transaccionCommandTestDataBuilder.conIdTransaccion(1);
		transaccionCommandTestDataBuilder.conBonificacionCommand(bonificacionCommand);
		transaccionCommandTestDataBuilder.conEmpleadoCommand(empleadoCommand);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();

		mockmvc.perform(delete("/api/coins/transacciones/{id}", transaccionCommand.getIdTransaccion()))
				.andExpect(status().isOk());
	}
	
	@Test
	public void obtenerTransaccionOk() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conIdBonificacion(1);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conIdEmpleado(1);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		transaccionCommandTestDataBuilder.esRedimido(false);
		transaccionCommandTestDataBuilder
				.conFechaObtencion(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		transaccionCommandTestDataBuilder
				.conFechaRedencion(new Calendar.Builder().setDate(2020, 9, 1).build().getTime());
		transaccionCommandTestDataBuilder.conIdBonificacion(1);
		transaccionCommandTestDataBuilder.conIdEmpleado(1);
		transaccionCommandTestDataBuilder.conIdTransaccion(1);
		transaccionCommandTestDataBuilder.conBonificacionCommand(bonificacionCommand);
		transaccionCommandTestDataBuilder.conEmpleadoCommand(empleadoCommand);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();
		this.mockmvc.perform(post("/api/coins/transaccion")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(transaccionCommand)))
				.andExpect(status().isOk());
		
		// Act - Assert
		this.mockmvc.perform(get("/api/coins/transaccion/{id}", transaccionCommand.getIdTransaccion())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(transaccionCommand))).andExpect(status().isOk());

	}
}
