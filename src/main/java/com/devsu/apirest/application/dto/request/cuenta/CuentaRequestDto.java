package com.devsu.apirest.application.dto.request.cuenta;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
public class CuentaRequestDto {

    @NotEmpty(message = "El tipo de cuenta es obligatorio.")
    private String tipoCuenta;

    private long saldoInicial;

    @NotEmpty(message = "La identificacion del cliente es obligatoria.")
    @Size(min = 6, max = 12, message = "Inserte una identificacion válida.")
    @Pattern(regexp = "^[0-9]{6,12}$", message = "El documento solo debe contener números.")
    private String identificacion;  // Se le asigna la cuenta a un documento (PK Persona)
}
