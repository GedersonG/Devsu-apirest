package com.devsu.apirest.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimiento")
public class MovimientoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimiento_id")
    private long movimientoId;

    @Column(nullable = false)
    private Date fecha = new Date();

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false, length = 6)
    private long valor;

    @Column(nullable = false, length = 15)
    private long saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta")
    private CuentaEntidad cuenta;
}
