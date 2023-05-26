package com.devsu.apirest.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class CuentaRequestDto {

    @NotEmpty(message = "El tipo de cuenta es obligatorio.")
    private String tipoCuenta;

    private long saldoInicial;

    @NotEmpty(message = "La identificacion del cliente es obligatoria.")
    private String identificacion;  // Se le asigna la cuenta a un documento (PK Persona)
}
