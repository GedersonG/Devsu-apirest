package com.devsu.apirest.application.dto.request.cliente;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class ClienteUpdateRequestDto {

    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres.")
    private String nombre;

    private String direccion;

    @Pattern(regexp = "^[0-9]{9}$", message = "El número de telefono no es valido.")
    private String telefono;
}
