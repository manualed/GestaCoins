package co.com.ceiba.adn.infrastructure.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.ceiba.adn.domain.model.entity.Transaccion;
import co.com.ceiba.adn.infrastructure.entity.TransactionEntity;

public class MapperTransaccion {
    public List<Transaccion> entityToModelList(List<TransactionEntity> entityList){
        return entityList.stream().map(MapperTransaccion::valueOfModel).collect(Collectors.toList());
    }
    
    private static Transaccion valueOfModel(TransactionEntity entity){
        return new Transaccion(entity.getEmpleado().getIdEmpleado(), entity.getBonificacion().getIdBonificacion(), 
        		entity.isRedimido(), entity.getFechaObtencion(), entity.getFechaRedencion());
    }
}
