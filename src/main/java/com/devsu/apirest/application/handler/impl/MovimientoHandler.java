package com.devsu.apirest.application.handler.impl;

import com.devsu.apirest.application.dto.request.MovimientoRequestDto;
import com.devsu.apirest.application.dto.request.MovimientoUpdateRequestDto;
import com.devsu.apirest.application.dto.response.MovimientoResponseDto;
import com.devsu.apirest.application.handler.IMovimientoHandler;
import com.devsu.apirest.application.mapper.request.IMovimientoRequestMapper;
import com.devsu.apirest.application.mapper.response.IMovimientoResponseMapper;
import com.devsu.apirest.domain.api.IMovimientoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovimientoHandler implements IMovimientoHandler {

    private final IMovimientoServicePort movimientoServicePort;
    private final IMovimientoRequestMapper movimientoRequestMapper;
    private final IMovimientoResponseMapper movimientoResponseMapper;

    @Override
    public void saveMovimiento(MovimientoRequestDto movimientoRequestDto) {

    }

    @Override
    public List<MovimientoResponseDto> getAllMovimientos() {
        return null;
    }

    @Override
    public void deleteMovimientoById(long id) {

    }

    @Override
    public MovimientoResponseDto getMovimientoById(long id) {
        return null;
    }

    @Override
    public void updateMovimientoById(long id, MovimientoUpdateRequestDto movimientoUpdateRequestDto) {

    }

    @Override
    public void editMovimientoById(long id, MovimientoRequestDto movimientoRequestDto) {

    }
}
