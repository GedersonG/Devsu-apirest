package com.devsu.apirest.application.dto.request.cliente;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteUpdateRequestDto {

    private String nombre;
    private String direccion;
    private String telefono;
}
