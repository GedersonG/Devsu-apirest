package com.devsu.apirest.domain.spi;

import com.devsu.apirest.domain.model.ClienteModelo;

import java.util.List;

public interface IClientePersistencePort {
    ClienteModelo saveCliente(ClienteModelo clienteModelo);

    List<ClienteModelo> getAllClientes();
}