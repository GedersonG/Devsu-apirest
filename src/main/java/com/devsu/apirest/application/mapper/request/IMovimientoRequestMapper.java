package com.devsu.apirest.application.mapper.request;

import com.devsu.apirest.application.dto.request.MovimientoRequestDto;
import com.devsu.apirest.application.dto.request.MovimientoUpdateRequestDto;
import com.devsu.apirest.domain.model.MovimientoModelo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMovimientoRequestMapper {

    MovimientoModelo toMovimiento(MovimientoRequestDto movimientoRequestDto);

    MovimientoModelo dtoUpdateToMovimiento(MovimientoUpdateRequestDto movimientoUpdateRequestDto);
}
