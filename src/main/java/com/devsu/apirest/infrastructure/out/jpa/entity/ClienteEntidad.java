package com.devsu.apirest.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class ClienteEntidad extends PersonaEntidad {

    @Id
    @GeneratedValue
    @Column(name = "id_cliente")
    private Long clienteId;

    @Column(nullable = false, length = 4)
    private String clave;

    @Column(nullable = false)
    private boolean estado = true;
}
