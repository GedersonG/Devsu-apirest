package com.devsu.apirest.application.handler;

import com.devsu.apirest.application.dto.request.CuentaRequestDto;
import com.devsu.apirest.application.dto.request.CuentaUpdateRequestDto;
import com.devsu.apirest.application.dto.response.CuentaResponseDto;

import java.util.List;

public interface ICuentaHandler {

    void saveCuenta(CuentaRequestDto cuentaRequestDto);

    List<CuentaResponseDto> getAllCuentas();

    void deleteCuentaById(long id);

    CuentaResponseDto getCuentaById(long id);

    void updateCuentaById(long id, CuentaUpdateRequestDto cuentaUpdateRequestDto);

    void editCuentaById(long id, CuentaRequestDto cuentaRequestDto);
}
