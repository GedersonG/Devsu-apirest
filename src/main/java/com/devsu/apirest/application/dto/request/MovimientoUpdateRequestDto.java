package com.devsu.apirest.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MovimientoUpdateRequestDto {

    @NotEmpty(message = "Debe ingresar un valor")
    private long valor;
}
