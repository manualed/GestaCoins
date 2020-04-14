package co.com.ceiba.adn.infrastructure;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Before;
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

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.driver.BonificacionDriver;
import co.com.ceiba.adn.application.factory.BonificacionFactory;
import co.com.ceiba.adn.builder.BonificacionTestDataBuilder;
import co.com.ceiba.adn.databuilder.BonificacionCommandTestDataBuilder;
import co.com.ceiba.adn.domain.exception.RequiredValueException;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.port.repository.IBonificacionRepository;
import co.com.ceiba.adn.domain.service.BonificacionService;
import co.com.ceiba.adn.infrastructure.controller.BonificacionController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BonificacionControllerTest {
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
	public void crearBonificacion() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conCodigoBonificacion("M0009");
		bonificacionCommandTestDataBuilder.conIdBonificacion(1);
		bonificacionCommandTestDataBuilder.conNombreBonificacion("INCEPCION PROCESO");
		bonificacionCommandTestDataBuilder.conTipoBonificacion(0);
		bonificacionCommandTestDataBuilder.conValorBonificacion(150000);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();

		// Act - Assert
		this.mockmvc.perform(post("/api/coins/bonificacion").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(bonificacionCommand))).andExpect(status().isOk());

	}
	
	@Test
	public void eliminarBonificacion() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conCodigoBonificacion("M0009");
		bonificacionCommandTestDataBuilder.conIdBonificacion(2);
		bonificacionCommandTestDataBuilder.conNombreBonificacion("INCEPCION PROCESO");
		bonificacionCommandTestDataBuilder.conTipoBonificacion(0);
		bonificacionCommandTestDataBuilder.conValorBonificacion(150000);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();

		// Act - Assert
		this.mockmvc.perform(post("/api/coins/bonificacion").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(bonificacionCommand))).andExpect(status().isOk());
		// Act - Assert
		this.mockmvc.perform(delete("/api/coins/bonificaciones/{id}", bonificacionCommand.getIdBonificacion()))
				.andExpect(status().isOk());

	}

	@Test
	public void crearConDatosNulos() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conCodigoBonificacion(null);
		bonificacionCommandTestDataBuilder.conIdBonificacion(5L);
		bonificacionCommandTestDataBuilder.conNombreBonificacion(null);
		BonificacionCommand empleadoCommand = bonificacionCommandTestDataBuilder.build();

		// Act - Assert
		this.mockmvc
				.perform(post("/api/coins/empleado").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(empleadoCommand)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.excepcion").value(RequiredValueException.class.getSimpleName()));

	}

	@Test
	public void listaBonificacionOk() throws Exception {
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		String uri = "/api/coins/bonificaciones";
		this.mockmvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(bonificacionCommand))).andExpect(status().isOk());

	}

	@Test
	public void validarUpdateBonificacion() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conCodigoBonificacion("M0009");
		bonificacionCommandTestDataBuilder.conIdBonificacion(1);
		bonificacionCommandTestDataBuilder.conNombreBonificacion("INCEPCION PROCESO");
		bonificacionCommandTestDataBuilder.conTipoBonificacion(0);
		bonificacionCommandTestDataBuilder.conValorBonificacion(150000);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		// Act - Assert
		mockmvc.perform(put("/api/coins/bonificacion/{id}", bonificacionCommand.getIdBonificacion())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bonificacionCommand)))
				.andExpect(status().isOk());
	}

	@Test
	public void validarUpdateFailedBonificacion() throws Exception {
		// Arrange
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conCodigoBonificacion(null);
		bonificacionCommandTestDataBuilder.conIdBonificacion(1);
		bonificacionCommandTestDataBuilder.conNombreBonificacion("INCEPCION PROCESO");
		bonificacionCommandTestDataBuilder.conTipoBonificacion(0);
		bonificacionCommandTestDataBuilder.conValorBonificacion(150000);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		// Act - Assert
		mockmvc.perform(put("/api/coins/bonificacion/{id}", bonificacionCommand.getIdBonificacion())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bonificacionCommand)))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldObtainBonification() {
		IBonificacionRepository bonificacionRepositoryMock = Mockito.mock(IBonificacionRepository.class);
		BonificacionService bonificacionService = new BonificacionService(bonificacionRepositoryMock);
		BonificacionFactory bonificacionFactory = new BonificacionFactory();
		BonificacionDriver bonificacionDriver = new BonificacionDriver(bonificacionService,bonificacionFactory);
		BonificacionController bonificacionController = new BonificacionController(bonificacionDriver);
		Bonificacion bonificacion = new BonificacionTestDataBuilder().build();
		long id = 1L;
		bonificacionController.obtenerBonificacion(id);
		assertNotNull(bonificacion);
	}


}
