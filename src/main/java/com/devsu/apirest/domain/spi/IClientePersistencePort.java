package com.devsu.apirest.domain.spi;

import com.devsu.apirest.domain.model.ClienteModelo;

import java.util.List;

public interface IClientePersistencePort {
    ClienteModelo saveCliente(ClienteModelo clienteModelo);

    List<ClienteModelo> getAllClientes();

    ClienteModelo getClienteById(Long id);

    void deleteClienteById(Long id);

    void updateClienteById(Long id, ClienteModelo clienteModelo);

    void editClienteById(Long id, ClienteModelo clienteModelo);
}