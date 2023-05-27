package com.devsu.apirest.domain.usecase;

import com.devsu.apirest.application.dto.response.reporte.ReporteResponseDto;
import com.devsu.apirest.domain.api.IMovimientoServicePort;
import com.devsu.apirest.domain.model.MovimientoModelo;
import com.devsu.apirest.domain.model.MovimientoModelo;
import com.devsu.apirest.domain.spi.IMovimientoPersistencePort;
import com.devsu.apirest.domain.spi.IMovimientoPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class MovimientoUseCase implements IMovimientoServicePort {

    private final IMovimientoPersistencePort movimientoPersistencePort;

    public MovimientoUseCase(IMovimientoPersistencePort movimientoPersistencePort) {
        this.movimientoPersistencePort = movimientoPersistencePort;
    }

    @Override
    public void saveMovimiento(MovimientoModelo movimiento) {
        movimientoPersistencePort.saveMovimiento(movimiento);
    }

    @Override
    public List<MovimientoModelo> getAllMovimientos() {
        return movimientoPersistencePort.getAllMovimientos();
    }

    @Override
    public MovimientoModelo getMovimientoById(long id) {
        return movimientoPersistencePort.getMovimientoById(id);
    }

    @Override
    public void deleteMovimientoById(long id) {
        movimientoPersistencePort.deleteMovimientoById(id);
    }

    @Override
    public void updateMovimientoById(long id, MovimientoModelo movimientoModelo) {
        movimientoPersistencePort.updateMovimientoById(id, movimientoModelo);
    }

    @Override
    public void editMovimientoById(long id, MovimientoModelo movimientoModelo) {
        movimientoPersistencePort.editMovimientoById(id, movimientoModelo);
    }

    @Override
    public List<ReporteResponseDto> getReportesByIdentificacion(String identificacion, String[] fecha) {
        return movimientoPersistencePort.getReportesByIdentificacion(identificacion, fecha);
    }
}
