package com.devsu.apirest.infrastructure.out.jpa.adapter;

import com.devsu.apirest.domain.model.MovimientoModelo;
import com.devsu.apirest.domain.spi.IMovimientoPersistencePort;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IClienteEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.mapper.ICuentaEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IMovimientoEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.IClienteRepository;
import com.devsu.apirest.infrastructure.out.jpa.repository.ICuentaRepository;
import com.devsu.apirest.infrastructure.out.jpa.repository.IMovimientoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MovimientoJpaAdapter implements IMovimientoPersistencePort {

    private final ICuentaRepository cuentaRepository;
    private final IMovimientoRepository movimientoRepository;
    private final ICuentaEntityMapper cuentaEntityMapper;
    private final IMovimientoEntityMapper movimientoEntityMapper;

    @Override
    public MovimientoModelo saveMovimiento(MovimientoModelo movimiento) {
        return null;
    }

    @Override
    public List<MovimientoModelo> getAllMovimientos() {
        return null;
    }

    @Override
    public boolean existsMovimientoById(long id) {
        return false;
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
