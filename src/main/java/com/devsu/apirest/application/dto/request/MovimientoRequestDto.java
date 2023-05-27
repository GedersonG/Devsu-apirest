package com.devsu.apirest.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class MovimientoRequestDto {

    @NotEmpty(message = "El valor del movimiento es obligatorio.")
    @Min(value = -1000, message = "El valor mínimo para un retiro es de $1000.")
    @Max(value = 1000, message = "El valor máximo para un deposito es de $1000.")
    private long valor;

    @NotEmpty(message = "Debe especificar el numero de cuenta que hace el movimiento")
    @Size(min = 6, max = 12, message = "Inserte un numero de cuenta válido.")
    @Pattern(regexp = "^[0-9]{6,7}$", message = "El numero de cuenta solo debe contener números.")
    private long numeroCuenta;
}
