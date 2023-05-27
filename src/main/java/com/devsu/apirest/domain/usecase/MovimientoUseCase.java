package com.devsu.apirest.domain.usecase;

import com.devsu.apirest.domain.api.IMovimientoServicePort;
import com.devsu.apirest.domain.model.MovimientoModelo;
import com.devsu.apirest.domain.spi.IMovimientoPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MovimientoUseCase implements IMovimientoServicePort {

    private final IMovimientoPersistencePort movimientoPersistencePort;

    @Override
    public void saveMovimiento(MovimientoModelo movimiento) {

    }

    @Override
    public List<MovimientoModelo> getAllMovimientos() {
        return null;
    }

    @Override
    public MovimientoModelo getMovimientoById(long id) {
        return null;
    }

    @Override
    public void deleteMovimientoById(long id) {

    }

    @Override
    public void updateMovimientoById(long id, MovimientoModelo movimientoModelo) {

    }

    @Override
    public void editMovimientoById(long id, MovimientoModelo movimientoModelo) {

    }
}
