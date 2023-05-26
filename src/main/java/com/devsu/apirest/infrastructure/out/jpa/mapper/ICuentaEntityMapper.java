package com.devsu.apirest.infrastructure.out.jpa.mapper;

import com.devsu.apirest.domain.model.CuentaModelo;
import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICuentaEntityMapper {

    CuentaEntidad toEntity(CuentaModelo cuentaModelo);
    CuentaModelo toCuentaModelo(CuentaEntidad cuentaEntidad);
    List<CuentaModelo> toCuentaModeloList(List<CuentaEntidad> cuentaEntidadList);
}
