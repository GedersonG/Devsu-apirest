package com.devsu.apirest.domain.api;

import com.devsu.apirest.domain.model.ClienteModelo;

import java.util.List;

public interface IClienteServicePort {

    void saveCliente(ClienteModelo clienteModelo);

    List<ClienteModelo> getAllClientes();

    ClienteModelo getClienteById(long id);

    void deleteClienteById(long id);

    void updateClienteById(long id, ClienteModelo  clienteModelo);

    void editClienteById(long id, ClienteModelo clienteModelo);

    void existsByIdentificacion(String identificacion);
}