package com.devsu.apirest.application.mapper.response;

import com.devsu.apirest.application.dto.response.movimiento.MovimientoResponseDto;
import com.devsu.apirest.domain.model.MovimientoModelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMovimientoResponseMapper {

    @Mapping(target = "cuenta", source = "cuenta.numeroCuenta")
    MovimientoResponseDto toResponse(MovimientoModelo movimientoModelo);

    List<MovimientoResponseDto> toResponseList(List<MovimientoModelo> movimientoModeloList);
}
