package com.devsu.apirest.domain.usecase;

import com.devsu.apirest.domain.api.IClienteServicePort;
import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.domain.spi.IClientePersistencePort;

import java.util.List;

public class ClienteUseCase implements IClienteServicePort {

    private final IClientePersistencePort clientePersistencePort;

    public ClienteUseCase(IClientePersistencePort clientePersistencePort) {
        this.clientePersistencePort = clientePersistencePort;
    }

    @Override
    public void saveCliente(ClienteModelo clienteModelo) {
        clientePersistencePort.saveCliente(clienteModelo);
    }

    @Override
    public List<ClienteModelo> getAllClientes() {
        return clientePersistencePort.getAllClientes();
    }

    @Override
    public ClienteModelo getClienteById(long id) {
        return clientePersistencePort.getClienteById(id);
    }

    @Override
    public boolean existsClienteById(long id) {
        return clientePersistencePort.existsClienteById(id);
    }

    @Override
    public void deleteClienteById(long id) {
        clientePersistencePort.deleteClienteById(id);
    }

    @Override
    public void updateClienteById(long id, ClienteModelo clienteModelo) {
        clientePersistencePort.updateClienteById(id, clienteModelo);
    }

    @Override
    public void editClienteById(long id, ClienteModelo clienteModelo) {
        clientePersistencePort.editClienteById(id, clienteModelo);
    }

}