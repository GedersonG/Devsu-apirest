package com.devsu.apirest.application.dto.request.cuenta;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CuentaUpdateRequestDto {

    @NotEmpty(message = "Debe insertar el saldo inicial")
    long saldoInicial;
}
