package com.devsu.apirest.domain.api;

import com.devsu.apirest.domain.model.CuentaModelo;

import java.util.List;

public interface ICuentaServicePort {
    void saveCuenta(CuentaModelo cuenta);

    List<CuentaModelo> getAllCuentas();
}
