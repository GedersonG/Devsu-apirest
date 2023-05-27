package com.devsu.apirest.application.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CuentaResponseDto {

    private String numeroCuenta;
    private String tipoCuenta;
    private long saldoInicial;
    private boolean estado;
    private String nombre;
}
