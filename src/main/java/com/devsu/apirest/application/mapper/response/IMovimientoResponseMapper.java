package com.devsu.apirest.application.mapper.response;

import com.devsu.apirest.application.dto.response.MovimientoResponseDto;
import com.devsu.apirest.domain.model.MovimientoModelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMovimientoResponseMapper {

    MovimientoResponseDto toResponse(MovimientoModelo movimientoModelo);

    @Mapping(target = "cuenta", source = "cuenta.numeroCuenta")
    List<MovimientoResponseDto> toResponseList(List<MovimientoModelo> movimientoModeloList);
}
