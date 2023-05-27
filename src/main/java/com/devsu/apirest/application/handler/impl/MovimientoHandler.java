package com.devsu.apirest.application.handler.impl;

import com.devsu.apirest.application.dto.request.MovimientoRequestDto;
import com.devsu.apirest.application.dto.request.MovimientoUpdateRequestDto;
import com.devsu.apirest.application.dto.response.MovimientoResponseDto;
import com.devsu.apirest.application.handler.IMovimientoHandler;
import com.devsu.apirest.application.mapper.request.IMovimientoRequestMapper;
import com.devsu.apirest.application.mapper.response.IMovimientoResponseMapper;
import com.devsu.apirest.domain.api.IMovimientoServicePort;
import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.domain.model.CuentaModelo;
import com.devsu.apirest.domain.model.MovimientoModelo;
import com.devsu.apirest.infrastructure.out.jpa.entity.MovimientoEntidad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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
        movimientoServicePort.saveMovimiento(adjustMovimiento(movimientoRequestDto));
    }

    @Override
    public List<MovimientoResponseDto> getAllMovimientos() {
        return movimientoResponseMapper.toResponseList(movimientoServicePort.getAllMovimientos());
    }

    @Override
    public void deleteMovimientoById(long id) {
        movimientoServicePort.deleteMovimientoById(id);
    }

    @Override
    public MovimientoResponseDto getMovimientoById(long id) {
        return movimientoResponseMapper.toResponse(movimientoServicePort.getMovimientoById(id));
    }

    @Override
    public void updateMovimientoById(long id, MovimientoUpdateRequestDto movimientoUpdateRequestDto) {
        movimientoServicePort.updateMovimientoById(
                id,
                movimientoRequestMapper.dtoUpdateToMovimiento(
                        movimientoUpdateRequestDto
                )
        );
    }

    @Override
    public void editMovimientoById (long id, MovimientoRequestDto movimientoRequestDto) {
        movimientoServicePort.editMovimientoById(id, adjustMovimiento(movimientoRequestDto));
    }

    private MovimientoModelo adjustMovimiento (MovimientoRequestDto movimientoRequestDto) {

        MovimientoModelo movimientoModelo = movimientoRequestMapper.toMovimiento(movimientoRequestDto);

        CuentaModelo cuentaModelo = new CuentaModelo();
        cuentaModelo.setNumeroCuenta(movimientoRequestDto.getCuenta());

        movimientoModelo.setCuenta(cuentaModelo);

        return movimientoModelo;
    }
}
