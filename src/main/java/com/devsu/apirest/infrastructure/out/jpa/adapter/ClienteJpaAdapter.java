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
}