package co.com.ceiba.adn.infrastructure.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.com.ceiba.adn.infrastructure.adapter.mapper.Mapper;

import co.com.ceiba.adn.domain.port.repository.IBonificacionRepository;
import co.com.ceiba.adn.domain.port.repository.IEmpleadoRepository;
import co.com.ceiba.adn.domain.service.BonificacionService;
import co.com.ceiba.adn.domain.service.EmpleadoService;

@Configuration
public class ConfigurationBeans {
	@Bean
    public BonificacionService bonificacionService(IBonificacionRepository bonificacionRepository){
        return new BonificacionService(bonificacionRepository);
    }
	@Bean
    public EmpleadoService empleadoService(IEmpleadoRepository empleadoRepository){
        return new EmpleadoService(empleadoRepository);
    }
	
//	@Bean
//	public TransaccionService servicioCrearCompra(ITransaccionRepository transaccionRepository) {
//		return new TransaccionService(transaccionRepository);
//	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
//	@Bean
//	public Mapper mapper() {
//		return new Mapper();
//	}
}
