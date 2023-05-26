package com.devsu.apirest.infrastructure.out.jpa.mapper;

import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IClienteEntityMapper {

    ClienteEntidad toEntity(ClienteModelo clienteModelo);
    ClienteModelo toClienteModelo(ClienteEntidad clienteEntidad);
    List<ClienteModelo> toClienteModeloList(List<ClienteEntidad> clienteEntidadList);
}