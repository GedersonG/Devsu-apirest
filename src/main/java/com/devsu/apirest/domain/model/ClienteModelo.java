package com.devsu.apirest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.Super;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClienteModelo extends PersonaModelo {

    private Long clienteId;
    private String clave;
    private boolean estado = true;
}
