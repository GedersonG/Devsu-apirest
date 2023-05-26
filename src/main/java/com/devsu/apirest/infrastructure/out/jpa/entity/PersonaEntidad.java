package com.devsu.apirest.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Table(name = "persona")
public class PersonaEntidad {

    @Column(length = 50)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String direccion;

    @Column(length = 20, nullable = false)
    private String telefono;

    @Column(length = 20, nullable = false, unique = true)
    private String identificacion;

    @Column(length = 20)
    private String genero;

    @Column(length = 20, nullable = false)
    private short edad;
}
