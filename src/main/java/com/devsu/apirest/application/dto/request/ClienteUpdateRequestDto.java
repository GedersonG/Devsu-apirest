package com.devsu.apirest.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteUpdateRequestDto {

    private String nombre;
    private String direccion;
    private String telefono;
}
