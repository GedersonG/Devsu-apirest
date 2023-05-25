package com.devsu.apirest.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class PersonaEntidad {

    @NotNull
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres.")
    @Column(length = 50)
    private String nombre;

    @NotNull
    @NotBlank(message = "La direccion es obligatoria")
    @Column(length = 50, nullable = false)
    private String direccion;

    @NotNull
    @NotBlank(message = "El numero de telefono es obligatorio.")
    @Column(length = 20, nullable = false)
    private String telefono;

    @Column(length = 20, nullable = false, unique = true)
    private String identificacion;

    @Column(length = 20)
    private String genero;

    @Column(length = 20, nullable = false)
    private short edad;
}
