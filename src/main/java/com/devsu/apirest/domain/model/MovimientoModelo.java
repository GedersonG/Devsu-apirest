package com.devsu.apirest.domain.model;

import java.util.Date;

public class MovimientoModelo {

    private long movimientoId;
    private Date fecha;
    private String tipo;
    private long valor;
    private long saldo;
    private CuentaModelo cuentaModelo;

    public MovimientoModelo(long movimientoId, Date fecha, String tipo, long valor, long saldo, CuentaModelo cuentaModelo) {
        this.movimientoId = movimientoId;
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
        this.saldo = saldo;
        this.cuentaModelo = cuentaModelo;
    }

    public MovimientoModelo() {
    }

    public long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public CuentaModelo getCuentaModelo() {
        return cuentaModelo;
    }

    public void setCuentaModelo(CuentaModelo cuentaModelo) {
        this.cuentaModelo = cuentaModelo;
    }
}
