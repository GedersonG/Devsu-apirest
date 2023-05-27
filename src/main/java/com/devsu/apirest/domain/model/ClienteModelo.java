package com.devsu.apirest.domain.model;

import lombok.ToString;

@ToString
public class ClienteModelo extends PersonaModelo {

    private Long clienteId;

    private String clave;

    private boolean estado;

    public ClienteModelo() {
    }

    public ClienteModelo(String nombre, String genero, short edad, String identificacion, String direccion, String telefono, Long clienteId, String clave, boolean estado) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.clienteId = clienteId;
        this.clave = clave;
        this.estado = estado;
    }

    public ClienteModelo(Long clienteId, String clave, boolean estado) {
        this.clienteId = clienteId;
        this.clave = clave;
        this.estado = estado;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
