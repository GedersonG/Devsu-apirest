package com.devsu.apirest.application.dto.request.cuenta;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
public class CuentaUpdateRequestDto {

    @NotEmpty(message = "Debe insertar el saldo inicial")
    long saldoInicial;
}
