package com.devsu.apirest.domain.spi;

import com.devsu.apirest.domain.model.CuentaModelo;

import java.util.List;

public interface ICuentaPersistencePort {
    CuentaModelo saveCuenta(CuentaModelo cuenta);

    List<CuentaModelo> getAllCuentas();
}
