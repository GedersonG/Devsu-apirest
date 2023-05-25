package com.devsu.apirest.domain.api;

import com.devsu.apirest.domain.model.ClienteModelo;

import java.util.List;

public interface IClienteServicePort {

    void saveCliente(ClienteModelo clienteModelo);

    List<ClienteModelo> getAllClientes();
}