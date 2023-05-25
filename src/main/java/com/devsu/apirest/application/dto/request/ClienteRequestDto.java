package com.devsu.apirest.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDto {
    private String nombre;
    private String direccion;
    private String telefono;
    private String clave;
    private String identificacion;
    private short edad;
    private String genero;
}
