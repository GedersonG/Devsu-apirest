package com.devsu.apirest.application.mapper.response;

import com.devsu.apirest.application.dto.response.CuentaResponseDto;
import com.devsu.apirest.domain.model.CuentaModelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICuentaResponseMapper {
    CuentaResponseDto toResponse(CuentaModelo cuentaModelo);

    @Mapping(target = "nombre", source = "cliente.nombre")
    List<CuentaResponseDto> toResponseList(List<CuentaModelo> cuentaModeloList);
}
