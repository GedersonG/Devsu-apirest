package com.devsu.apirest.application.handler;

import com.devsu.apirest.application.dto.request.CuentaRequestDto;
import com.devsu.apirest.application.dto.response.CuentaResponseDto;

import java.util.List;

public interface ICuentaHandler {

    void saveCuenta(CuentaRequestDto cuentaRequestDto);

    List<CuentaResponseDto> getAllCuentas();
}
