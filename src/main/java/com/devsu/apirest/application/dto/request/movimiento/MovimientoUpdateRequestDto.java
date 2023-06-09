package com.devsu.apirest.application.dto.request.movimiento;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Builder
public class MovimientoUpdateRequestDto {

    @Min(value = 10, message = "El valor mínimo para un movimiento es de $10.")
    @Max(value = 1000, message = "El valor máximo para un movimiento es de $1000.")
    private long valor;

    @JsonCreator
    public MovimientoUpdateRequestDto(@JsonProperty("valor") long valor) {
        this.valor = valor;
    }
}
