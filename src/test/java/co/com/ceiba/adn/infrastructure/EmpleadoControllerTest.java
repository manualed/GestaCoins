package co.com.ceiba.adn.infrastructure;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import co.com.ceiba.adn.application.EmpleadoCommandTestDataBuilder;
import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.domain.exception.RequiredValueException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EmpleadoControllerTest {
	
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
    public void crearEmpleado() throws Exception {
        // Arrange
    	EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
    	empleadoCommandTestDataBuilder.conFechaIngreso(new Calendar.Builder().setDate(2012, 6, 4).build().getTime());
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
        this.mockmvc.perform(post("/api/coins/empleado")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleadoCommand)))
        		.andExpect(status().isBadRequest())
        		.andExpect(jsonPath("$.excepcion").value(RequiredValueException.class.getSimpleName()));
        		
    }
    

    
}
