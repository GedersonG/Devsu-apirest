package com.devsu.apirest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaModelo {

    private String nombre;
    private String genero;
    private short edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
