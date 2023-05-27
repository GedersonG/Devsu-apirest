package com.devsu.apirest.domain.usecase;

import com.devsu.apirest.domain.api.ICuentaServicePort;
import com.devsu.apirest.domain.model.CuentaModelo;
import com.devsu.apirest.domain.spi.ICuentaPersistencePort;

import java.util.List;

public class CuentaUseCase implements ICuentaServicePort {

    private final ICuentaPersistencePort cuentaPersistencePort;

    public CuentaUseCase(ICuentaPersistencePort cuentaPersistencePort) {
        this.cuentaPersistencePort = cuentaPersistencePort;
    }
    @Override
    public void saveCuenta(CuentaModelo cuenta) {
        cuentaPersistencePort.saveCuenta(cuenta);
    }

    @Override
    public List<CuentaModelo> getAllCuentas() {
        return cuentaPersistencePort.getAllCuentas();
    }

    @Override
    public CuentaModelo getCuentaById(long id) {
        return cuentaPersistencePort.getCuentaById(id);
    }

    @Override
    public void deleteCuentaById(long id) {
        cuentaPersistencePort.deleteCuentaById(id);
    }

    @Override
    public void updateCuentaById(long id, CuentaModelo cuentaModelo) {
        cuentaPersistencePort.updateCuentaById(id, cuentaModelo);
    }

    @Override
    public void editCuentaById(long id, CuentaModelo cuentaModelo) {
        cuentaPersistencePort.editCuentaById(id, cuentaModelo);
    }
}
