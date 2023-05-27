package com.devsu.apirest.application.dto.response.reporte;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReporteResponseDto {
    private String fecha;
    private String nombre;
    private long numeroCuenta;
    private String tipoCuenta;
    private long saldoInicial;
    private long valor;
    private long saldo;
}
