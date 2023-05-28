package com.devsu.apirest.application.dto.request.movimiento;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
public class MovimientoRequestDto {

    @Min(value = -1000, message = "El valor máximo para un retiro es de $1000.")
    @Max(value = 1000, message = "El valor máximo para un deposito es de $1000.")
    private long valor;

    private long cuenta;
}
