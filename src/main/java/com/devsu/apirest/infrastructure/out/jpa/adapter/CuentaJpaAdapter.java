package com.devsu.apirest.infrastructure.out.jpa.adapter;

import com.devsu.apirest.domain.model.CuentaModelo;
import com.devsu.apirest.domain.spi.ICuentaPersistencePort;
import com.devsu.apirest.infrastructure.exception.NoDataFoundException;
import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import com.devsu.apirest.infrastructure.out.jpa.mapper.ICuentaEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.ICuentaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CuentaJpaAdapter implements ICuentaPersistencePort {

    private final ICuentaRepository cuentaRepository;
    private final ICuentaEntityMapper cuentaEntityMapper;

    @Override
    public CuentaModelo saveCuenta(CuentaModelo cuenta) {
        CuentaEntidad cuentaEntidad = cuentaRepository.save(cuentaEntityMapper.toEntity(cuenta));
        return cuentaEntityMapper.toCuentaModelo(cuentaEntidad);
    }

    @Override
    public List<CuentaModelo> getAllCuentas() {
        List<CuentaEntidad> entityList = cuentaRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return cuentaEntityMapper.toCuentaModeloList(entityList);
    }
}
