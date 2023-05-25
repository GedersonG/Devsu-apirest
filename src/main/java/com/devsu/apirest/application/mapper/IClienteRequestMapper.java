package com.devsu.apirest.application.mapper;

import com.devsu.apirest.application.dto.request.ClienteRequestDto;
import com.devsu.apirest.domain.model.ClienteModelo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IClienteRequestMapper {
    ClienteModelo toCliente(ClienteRequestDto clienteRequestDto);
}
