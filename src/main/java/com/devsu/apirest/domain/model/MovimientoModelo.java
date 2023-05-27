package com.devsu.apirest.domain.model;

import java.util.Date;

public class MovimientoModelo {

    private long movimientoId;
    private String fecha;
    private String tipo;
    private long valor;
    private long saldo;
    private CuentaModelo cuenta;

    public MovimientoModelo(long movimientoId, String fecha, String tipo, long valor, long saldo, CuentaModelo cuenta) {
        this.movimientoId = movimientoId;
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public MovimientoModelo() {
    }

    public MovimientoModelo(MovimientoModelo movimiento) {
        this.movimientoId = movimiento.getMovimientoId();
        this.tipo = movimiento.getTipo();
        this.fecha = movimiento.getFecha();
        this.valor = movimiento.getValor();
        this.saldo = movimiento.getSaldo();
        this.cuenta = movimiento.getCuenta();
    }

    public long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public CuentaModelo getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaModelo cuentaModelo) {
        this.cuenta = cuentaModelo;
    }
}
