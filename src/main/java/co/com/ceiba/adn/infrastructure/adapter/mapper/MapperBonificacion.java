package co.com.ceiba.adn.infrastructure.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.ceiba.adn.domain.model.entity.Bonificacion;
import co.com.ceiba.adn.infrastructure.entity.BonificacionEntity;

public class MapperBonificacion {
    public List<Bonificacion> entityToModelList(List<BonificacionEntity> entityList){
        return entityList.stream().map(MapperBonificacion::valueOfModel).collect(Collectors.toList());
    }
    
    private static Bonificacion valueOfModel(BonificacionEntity entity){
        return new Bonificacion(entity.getIdBonificacion(), entity.getCodigoBonificacion(), entity.getNombreBonificacion(), 
        		entity.getValorBonificacion(), entity.getTipoBonificacion());
    }
}
