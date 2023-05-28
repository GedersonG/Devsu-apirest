package com.devsu.apirest.infrastructure.out.jpa.adapter;

import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.domain.spi.IClientePersistencePort;
import com.devsu.apirest.infrastructure.exception.AlreadyExistsException;
import com.devsu.apirest.infrastructure.exception.NoDataFoundException;
import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IClienteEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClienteJpaAdapter implements IClientePersistencePort {

    private static final Logger logger = LoggerFactory.getLogger(ClienteJpaAdapter.class);
    private final IClienteRepository clienteRepository;
    private final IClienteEntityMapper clienteEntityMapper;

    @Override
    public ClienteModelo saveCliente(ClienteModelo clienteModelo) {
        // Comprueba si la persona con esa identificacion ya existe.
        existsByIdentificacion(clienteModelo.getIdentificacion());

        ClienteEntidad clienteEntidad = clienteRepository.save(clienteEntityMapper.toEntity(clienteModelo));
        ClienteModelo savedCliente = clienteEntityMapper.toClienteModelo(clienteEntidad);

        logger.info("Cliente saved: {}", savedCliente);

        return savedCliente;
    }

    @Override
    public List<ClienteModelo> getAllClientes() {
        List<ClienteEntidad> entityList = clienteRepository.findAll();
        if (entityList.isEmpty()) {
            logger.error("No se encontraron clientes.");
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
            logger.error("No se encontró un cliente con el id {}", id);
            throw new NoDataFoundException();
        }
        logger.warn("Eliminando cliente...");
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
        logger.info("Actualizando cliente...");
        clienteRepository.save(clienteEntityMapper.toEntity(cliente));
    }

    @Override
    public void editClienteById(long id, ClienteModelo clienteModelo) {
        ClienteModelo clienteBefore = getClienteById(id);

        clienteRepository.delete(clienteEntityMapper.toEntity(clienteBefore));

        logger.info("Editando cliente: {} ", clienteModelo.getNombre());
        saveCliente(clienteModelo);
    }

    @Override
    public void existsByIdentificacion(String identificacion) {
        if (clienteRepository.existsByIdentificacion(identificacion)) {
            logger.error("El usuario con la identificacion {} ya existe.", identificacion);
            throw new AlreadyExistsException();
        }
    }
}