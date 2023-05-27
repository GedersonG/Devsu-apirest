package com.devsu.apirest.application.mapper.request;

import com.devsu.apirest.application.dto.request.cuenta.CuentaRequestDto;
import com.devsu.apirest.application.dto.request.cuenta.CuentaUpdateRequestDto;
import com.devsu.apirest.domain.model.CuentaModelo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICuentaRequestMapper {

    CuentaModelo toCuenta(CuentaRequestDto cuentaRequestDto);

    CuentaModelo dtoUpdateToCuenta(CuentaUpdateRequestDto cuentaUpdateRequestDto);
}
