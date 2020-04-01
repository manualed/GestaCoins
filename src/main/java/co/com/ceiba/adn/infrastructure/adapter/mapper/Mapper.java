package co.com.ceiba.adn.infrastructure.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.ceiba.adn.domain.model.entity.Empleado;
import co.com.ceiba.adn.infrastructure.entity.EmpleadoEntity;

public class Mapper {
    public List<Empleado> entityToModelList(List<EmpleadoEntity> entityList){
        return entityList.stream().map(Mapper::valueOfModel).collect(Collectors.toList());
    }
    
    private static Empleado valueOfModel(EmpleadoEntity entity){
        return new Empleado(entity.getIdEmpleado(), entity.getTipoDocumento(), entity.getNumeroDocumento(), 
        		entity.getPrimerNombre(), entity.getPrimerApellido(), entity.getFechaIngreso(), entity.getFechaNacimiento(), 
        		entity.getFechaCambio(), entity.getEmail());
    }
}

