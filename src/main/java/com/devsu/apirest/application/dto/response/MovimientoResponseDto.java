package com.devsu.apirest.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
