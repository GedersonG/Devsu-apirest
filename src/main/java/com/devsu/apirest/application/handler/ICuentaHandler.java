package com.devsu.apirest.application.handler;

import com.devsu.apirest.application.dto.request.cuenta.CuentaRequestDto;
import com.devsu.apirest.application.dto.request.cuenta.CuentaUpdateRequestDto;
import com.devsu.apirest.application.dto.response.cuenta.CuentaResponseDto;

import java.util.List;

public interface ICuentaHandler {

    void saveCuenta (CuentaRequestDto cuentaRequestDto);

    List<CuentaResponseDto> getAllCuentas ();

    void deleteCuentaById (long id);

    CuentaResponseDto getCuentaById (long id);

    void updateCuentaById (long id, CuentaUpdateRequestDto cuentaUpdateRequestDto);

    void editCuentaById (long id, CuentaRequestDto cuentaRequestDto);
}
