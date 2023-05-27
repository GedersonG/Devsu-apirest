package com.devsu.apirest.domain.spi;

import com.devsu.apirest.application.dto.response.reporte.ReporteResponseDto;
import com.devsu.apirest.domain.model.MovimientoModelo;

import java.util.List;

public interface IMovimientoPersistencePort {

    MovimientoModelo saveMovimiento(MovimientoModelo movimiento);

    List<MovimientoModelo> getAllMovimientos();

    boolean existsMovimientoById(long id);

    MovimientoModelo getMovimientoById(long id);

    void deleteMovimientoById(long id);

    void updateMovimientoById(long id, MovimientoModelo movimientoModelo);

    void editMovimientoById(long id, MovimientoModelo movimientoModelo);

    List<ReporteResponseDto> getReportesByIdentificacion(String identificacion, String[] fecha);
}
