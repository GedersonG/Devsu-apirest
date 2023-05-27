package com.devsu.apirest.application.dto.response.movimiento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimientoResponseDto {

    private long movimientoId;
    private String fecha;
    private String tipo;
    private long valor;
    private long saldo;
    private long cuenta;
}
