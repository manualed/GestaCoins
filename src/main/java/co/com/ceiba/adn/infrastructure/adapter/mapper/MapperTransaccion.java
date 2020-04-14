package co.com.ceiba.adn.infrastructure.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.ceiba.adn.application.command.BonificacionCommand;
import co.com.ceiba.adn.application.command.EmpleadoCommand;
import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.domain.model.entity.Transaccion;
import co.com.ceiba.adn.infrastructure.entity.BonificacionEntity;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;
import co.com.ceiba.adn.infrastructure.entity.TransactionEntity;



public class MapperTransaccion {

    public List<Transaccion> entityToModelList(List<TransactionEntity> entityList){
        return entityList.stream().map(MapperTransaccion::valueOfModel).collect(Collectors.toList());
    }
    
    private static Transaccion valueOfModel(TransactionEntity entity){
    	EmpleadoEntity  empleadoEntity = entity.getEmpleado();
    	BonificacionEntity bonificacionEntity = entity.getBonificacion();
    	EmpleadoCommand empleadoCommand = new EmpleadoCommand(empleadoEntity.getIdEmpleado(),
    			empleadoEntity.getTipoDocumento(), empleadoEntity.getNumeroDocumento(),empleadoEntity.getPrimerNombre(),
    			empleadoEntity.getPrimerApellido(),empleadoEntity.getFechaIngreso(),empleadoEntity.getFechaNacimiento(),
    			empleadoEntity.getFechaCambio(),empleadoEntity.getEmail()); 
 
    	BonificacionCommand bonificacionCommand = new BonificacionCommand(bonificacionEntity.getIdBonificacion(), bonificacionEntity.getCodigoBonificacion(),
    			bonificacionEntity.getNombreBonificacion(),bonificacionEntity.getValorBonificacion(),
    			bonificacionEntity.getTipoBonificacion()); 
        return new Transaccion(entity.getIdTransaccion(),entity.getEmpleado().getIdEmpleado(), entity.getBonificacion().getIdBonificacion(), 
        		entity.isRedimido(), entity.getFechaObtencion(), entity.getFechaRedencion(),
        		new Empleado(empleadoCommand.getIdEmpleado(),
        				empleadoCommand.getTipoDocumento(), empleadoCommand.getNumeroDocumento(),empleadoCommand.getPrimerNombre(),
        				empleadoCommand.getPrimerApellido(),empleadoCommand.getFechaIngreso(),empleadoCommand.getFechaNacimiento(),
        				empleadoCommand.getFechaCambio(),empleadoCommand.getEmail()), 
        		new Bonificacion(bonificacionCommand.getIdBonificacion(), bonificacionCommand.getCodigoBonificacion(),
        				bonificacionCommand.getNombreBonificacion(),bonificacionCommand.getValorBonificacion(),
        				bonificacionCommand.getTipoBonificacion()));
    }
}
