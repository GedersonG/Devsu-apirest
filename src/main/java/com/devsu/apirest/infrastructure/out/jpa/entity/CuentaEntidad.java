package com.devsu.apirest.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cuenta")
public class CuentaEntidad {

    @Id
    @GeneratedValue(generator = "CUST_GEN")
    @Column(name = "id_cuenta")
    private long numeroCuenta;

    @Column(name = "tipo", nullable = false)
    private String tipoCuenta;

    @Column(name = "saldo_inicial", nullable = false)
    private long saldoInicial = 0l;

    @Column(nullable = false)
    private boolean estado = true;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private ClienteEntidad cliente;
}
