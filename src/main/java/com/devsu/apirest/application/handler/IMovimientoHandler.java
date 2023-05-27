package com.devsu.apirest.application.handler;

import com.devsu.apirest.application.dto.request.MovimientoRequestDto;
import com.devsu.apirest.application.dto.request.MovimientoUpdateRequestDto;
import com.devsu.apirest.application.dto.response.MovimientoResponseDto;

import java.util.List;

public interface IMovimientoHandler {

    void saveMovimiento (MovimientoRequestDto movimientoRequestDto);

    List<MovimientoResponseDto> getAllMovimientos ();

    void deleteMovimientoById (long id);

    MovimientoResponseDto getMovimientoById (long id);

    void updateMovimientoById (long id, MovimientoUpdateRequestDto movimientoUpdateRequestDto);

    void editMovimientoById (long id, MovimientoRequestDto movimientoRequestDto);
}
