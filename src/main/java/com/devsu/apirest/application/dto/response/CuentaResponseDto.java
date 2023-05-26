package com.devsu.apirest.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CuentaResponseDto {

    private String numeroCuenta;
    private String tipoCuenta;
    private long saldoInicial;
    private boolean estado;
    private String nombre;
}
