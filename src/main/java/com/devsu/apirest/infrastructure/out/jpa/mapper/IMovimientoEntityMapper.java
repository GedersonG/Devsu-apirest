package com.devsu.apirest.infrastructure.out.jpa.mapper;

import com.devsu.apirest.domain.model.MovimientoModelo;
import com.devsu.apirest.infrastructure.out.jpa.entity.MovimientoEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IMovimientoEntityMapper {

    MovimientoEntidad toEntity(MovimientoModelo movimientoModelo);
    MovimientoModelo toMovimientoModelo(MovimientoEntidad movimientoEntidad);
    List<MovimientoModelo> toMovimientoModeloList(List<MovimientoEntidad> movimientoEntidadList);
}
