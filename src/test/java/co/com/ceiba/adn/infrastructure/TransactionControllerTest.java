package co.com.ceiba.adn.infrastructure;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import co.com.ceiba.adn.application.command.TransaccionCommand;
import co.com.ceiba.adn.databuilder.TransaccionCommandTestDataBuilder;
import co.com.ceiba.adn.domain.exception.RequiredValueException;

@RunWith(SpringRunner.class)
@SpringBootTest
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
	public void crearTransaccion() throws Exception {
		// Arrange
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		transaccionCommandTestDataBuilder.esRedimido(false);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();

		// Act - Assert
		this.mockmvc.perform(post("/api/coins/transaccion").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(transaccionCommand))).andExpect(status().isOk());

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
}
