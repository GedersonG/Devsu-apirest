package com.devsu.apirest.application.dto.response.cliente;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteResponseDto {

    private Long clienteId;
    private String nombre;
    private String direccion;
    private int edad;
    private String identificacion;
    private String telefono;
    private boolean estado;
    private String genero;
}
