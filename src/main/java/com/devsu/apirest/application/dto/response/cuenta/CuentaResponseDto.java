package com.devsu.apirest.application.dto.response.cuenta;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CuentaResponseDto {

    private String numeroCuenta;
    private String tipoCuenta;
    private long saldoInicial;
    private boolean estado;
    private String nombre;
}
