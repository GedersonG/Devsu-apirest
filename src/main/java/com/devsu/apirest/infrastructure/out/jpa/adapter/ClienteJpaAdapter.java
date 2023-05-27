package com.devsu.apirest.infrastructure.out.jpa.adapter;

import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.domain.spi.IClientePersistencePort;
import com.devsu.apirest.infrastructure.exception.NoDataFoundException;
import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IClienteEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClienteJpaAdapter implements IClientePersistencePort {

    private final IClienteRepository clienteRepository;
    private final IClienteEntityMapper clienteEntityMapper;


    @Override
    public ClienteModelo saveCliente(ClienteModelo clienteModelo) {
        ClienteEntidad clienteEntidad = clienteRepository.save(clienteEntityMapper.toEntity(clienteModelo));
        return clienteEntityMapper.toClienteModelo(clienteEntidad);
    }

    @Override
    public List<ClienteModelo> getAllClientes() {
        List<ClienteEntidad> entityList = clienteRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return clienteEntityMapper.toClienteModeloList(entityList);
    }

    @Override
    public ClienteModelo getClienteById(long id) {
        ClienteEntidad cliente =
                clienteRepository.findById(id).orElseThrow(NoDataFoundException::new);
        return clienteEntityMapper.toClienteModelo(cliente);
    }

    @Override
    public boolean existsClienteById(long id) {
        return clienteRepository.existsById(id);
    }

    @Override
    public void deleteClienteById(long id) {
        if(!existsClienteById(id)) {
            throw new NoDataFoundException();
        }
        clienteRepository.deleteById(id);
    }

    @Override
    public void updateClienteById(long id, ClienteModelo clienteModelo) {
        ClienteModelo cliente = getClienteById(id);

        if(clienteModelo.getNombre() != null) {
            cliente.setNombre(clienteModelo.getNombre());
        }
        if(clienteModelo.getDireccion() != null) {
            cliente.setDireccion(clienteModelo.getDireccion());
        }
        if(clienteModelo.getTelefono() != null) {
            cliente.setTelefono(clienteModelo.getTelefono());
        }

        clienteRepository.save(clienteEntityMapper.toEntity(cliente));
    }

    @Override
    public void editClienteById(long id, ClienteModelo clienteModelo) {
        ClienteModelo clienteBefore = getClienteById(id);

        clienteRepository.delete(clienteEntityMapper.toEntity(clienteBefore));

        saveCliente(clienteModelo);
    }
}