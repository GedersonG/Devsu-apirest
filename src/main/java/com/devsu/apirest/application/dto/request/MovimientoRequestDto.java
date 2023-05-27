package com.devsu.apirest.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MovimientoRequestDto {

    @NotEmpty(message = "Debe especificar que tipo de movimiento desea ejecutar.")
    private String tipo;

    @NotEmpty(message = "El valor del movimiento es obligatorio.")
    @Min(value = 10, message = "El valor mínimo para un movimiento es de $10.")
    @Max(value = 1000, message = "El valor máximo para un movimiento es de $1000.")
    private long valor;
}
