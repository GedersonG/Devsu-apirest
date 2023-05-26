package com.devsu.apirest.application.handler.impl;

import com.devsu.apirest.application.dto.request.CuentaRequestDto;
import com.devsu.apirest.application.dto.response.CuentaResponseDto;
import com.devsu.apirest.application.handler.ICuentaHandler;
import com.devsu.apirest.application.mapper.request.ICuentaRequestMapper;
import com.devsu.apirest.application.mapper.response.ICuentaResponseMapper;
import com.devsu.apirest.domain.api.ICuentaServicePort;
import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.domain.model.CuentaModelo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CuentaHandler implements ICuentaHandler {

    private final ICuentaServicePort cuentaServicePort;
    private final ICuentaRequestMapper cuentaRequestMapper;
    private final ICuentaResponseMapper cuentaResponseMapper;

    @Override
    public void saveCuenta(CuentaRequestDto cuentaRequestDto) {
        CuentaModelo cuentaModelo = cuentaRequestMapper.toCuenta(cuentaRequestDto);
        cuentaModelo.getCliente().setIdentificacion(cuentaRequestDto.getIdentificacion());
        cuentaModelo.setEstado(true);
        cuentaServicePort.saveCuenta(cuentaModelo);
    }

    @Override
    public List<CuentaResponseDto> getAllCuentas() {
        return cuentaResponseMapper.toResponseList(cuentaServicePort.getAllCuentas());
    }
}
