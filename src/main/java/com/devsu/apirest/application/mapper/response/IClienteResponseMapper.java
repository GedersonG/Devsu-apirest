package com.devsu.apirest.application.mapper.response;

import com.devsu.apirest.application.dto.response.ClienteResponseDto;
import com.devsu.apirest.domain.model.ClienteModelo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IClienteResponseMapper {
    ClienteResponseDto toResponse(ClienteModelo clienteModelo);

    List<ClienteResponseDto> toResponseList(List<ClienteModelo> clienteModeloList);
}
