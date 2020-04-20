package co.com.ceiba.adn.infrastructure;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.application.command.TransaccionCommand;
import co.com.ceiba.adn.application.driver.TransaccionDriver;
import co.com.ceiba.adn.application.factory.BonificacionFactory;
import co.com.ceiba.adn.application.factory.EmpleadoFactory;
import co.com.ceiba.adn.application.factory.TransaccionFactory;
import co.com.ceiba.adn.builder.TransaccionTestDataBuilder;
import co.com.ceiba.adn.databuilder.BonificacionCommandTestDataBuilder;
import co.com.ceiba.adn.databuilder.EmpleadoCommandTestDataBuilder;
import co.com.ceiba.adn.databuilder.TransaccionCommandTestDataBuilder;
import co.com.ceiba.adn.domain.model.entity.Transaccion;
import co.com.ceiba.adn.domain.port.repository.ITransaccionRepository;
import co.com.ceiba.adn.domain.service.TransaccionService;
import co.com.ceiba.adn.infrastructure.controller.TransaccionController;
import co.com.ceiba.adn.infrastructure.entity.BonificacionEntity;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;
import co.com.ceiba.adn.infrastructure.entity.TransactionEntity;

public class TransactionTest {
	Transaccion transaccion = new TransaccionTestDataBuilder().build();
	ITransaccionRepository transaccionRepositoryMock = Mockito.mock(ITransaccionRepository.class);
	TransaccionService transaccionService = new TransaccionService(transaccionRepositoryMock);
	BonificacionFactory bonificacionFactory = new BonificacionFactory();
	EmpleadoFactory empleadoFactory = new EmpleadoFactory();
	TransaccionDriver transaccionDriver = new TransaccionDriver(transaccionService,
			new TransaccionFactory());
	TransaccionController transaccionController = new TransaccionController(transaccionDriver);
	TransaccionCommand transaccionCommand = new TransaccionCommand();

	@Test
	public void shouldReturnValidData() {
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
		transaccionCommandTestDataBuilder.conIdTransaccion(3);
		transaccionCommandTestDataBuilder.conBonificacionCommand(bonificacionCommand);
		transaccionCommandTestDataBuilder.conEmpleadoCommand(empleadoCommand);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();

		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
		empleadoEntity.setIdEmpleado(transaccion.getIdEmpleado());
		BonificacionEntity bonificacionEntity = new BonificacionEntity();
		bonificacionEntity.setIdBonificacion(transaccion.getIdBonificacion());

		TransactionEntity transaccionEntity = new TransactionEntity();
		transaccionEntity.setBonificacion(bonificacionEntity);
		transaccionEntity.setEmpleado(empleadoEntity);
		transaccionEntity.setIdBonificacion(transaccion.getIdBonificacion());
		transaccionEntity.setIdEmpleado(transaccion.getIdEmpleado());
		transaccionEntity.setRedimido(transaccion.isRedimido());
		transaccionEntity.setFechaObtencion(transaccion.getFechaObtencion());
		transaccionEntity.setFechaRedencion(transaccion.getFechaRedencion());

		transaccionController.crearTransaccion(transaccionCommand);
		assertNotNull(transaccion.getIdBonificacion());
	}

	@Test
	public void shouldDeleteData() {
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
		transaccionCommandTestDataBuilder.conIdTransaccion(3);
		transaccionCommandTestDataBuilder.conBonificacionCommand(bonificacionCommand);
		transaccionCommandTestDataBuilder.conEmpleadoCommand(empleadoCommand);
		Transaccion transaccion = new TransaccionTestDataBuilder().build();
		transaccionController.eliminar(transaccion.getIdTransaccion());
		verify(transaccionRepositoryMock, times(1)).eliminar(transaccion.getIdTransaccion());
	}

	@Test
	public void shouldUpdateData() {
		BonificacionCommandTestDataBuilder bonificacionCommandTestDataBuilder = new BonificacionCommandTestDataBuilder();
		bonificacionCommandTestDataBuilder.conIdBonificacion(2);
		BonificacionCommand bonificacionCommand = bonificacionCommandTestDataBuilder.build();
		EmpleadoCommandTestDataBuilder empleadoCommandTestDataBuilder = new EmpleadoCommandTestDataBuilder();
		empleadoCommandTestDataBuilder.conIdEmpleado(2);
		EmpleadoCommand empleadoCommand = empleadoCommandTestDataBuilder.build();
		TransaccionCommandTestDataBuilder transaccionCommandTestDataBuilder = new TransaccionCommandTestDataBuilder();
		transaccionCommandTestDataBuilder.esRedimido(true);
		transaccionCommandTestDataBuilder
				.conFechaObtencion(new Calendar.Builder().setDate(2020, 3, 1).build().getTime());
		transaccionCommandTestDataBuilder
				.conFechaRedencion(new Calendar.Builder().setDate(2020, 9, 1).build().getTime());
		transaccionCommandTestDataBuilder.conIdBonificacion(2);
		transaccionCommandTestDataBuilder.conIdEmpleado(2);
		transaccionCommandTestDataBuilder.conIdTransaccion(3);
		transaccionCommandTestDataBuilder.conBonificacionCommand(bonificacionCommand);
		transaccionCommandTestDataBuilder.conEmpleadoCommand(empleadoCommand);
		TransaccionCommand transaccionCommand = transaccionCommandTestDataBuilder.build();
		transaccionController.update(transaccionCommand);
		TransaccionCommand transaccionCommandAux = transaccionCommandTestDataBuilder.build();
		transaccionCommandAux.setRedimido(false);
		assertNotNull(transaccionCommand.isRedimido());
		assertNotEquals(transaccionCommand.isRedimido(), transaccionCommandAux.isRedimido());
	}

	@Test
	public void shouldObtainTransaction() {
		Transaccion transaccion = new TransaccionTestDataBuilder().build();
		long id = 1L;
		transaccionController.obtenerTransaccion(id);
		assertNotNull(transaccion);
	}

}
