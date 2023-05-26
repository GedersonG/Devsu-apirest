package com.devsu.apirest.domain.model;

public class CuentaModelo {

    private long numeroCuenta;
    private String tipoCuenta;
    private long saldoInicial;
    private boolean estado;
    private ClienteModelo cliente;

    public CuentaModelo(long numeroCuenta, String tipoCuenta, long saldoInicial, boolean estado, ClienteModelo cliente) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.cliente = cliente;
    }

    public CuentaModelo() {
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public long getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ClienteModelo getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModelo cliente) {
        this.cliente = cliente;
    }
}
