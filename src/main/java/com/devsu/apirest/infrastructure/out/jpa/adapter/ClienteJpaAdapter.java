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

        logger.info("Cliente saved: {}", savedCliente.getNombre());

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
    public ClienteModelo getClienteById(Long id) {
        ClienteEntidad cliente =
                clienteRepository.findById(id).orElseThrow(NoDataFoundException::new);
        return clienteEntityMapper.toClienteModelo(cliente);
    }

    @Override
    public void deleteClienteById(Long id) {
        // Comprueba si el cliente con el id existe.
        existsClienteById(id);      
        
        logger.warn("Eliminando cliente...");
        clienteRepository.deleteById(id);
    }

    @Override
    public void updateClienteById(Long id, ClienteModelo clienteModelo) {
        // Comprueba si el cliente con el id existe.
        existsClienteById(id);

        logger.info("Actualizando cliente...");
        
        clienteRepository.updateCliente(
                id, 
                clienteModelo.getNombre(), 
                clienteModelo.getDireccion(), 
                clienteModelo.getTelefono()
        );
    }

    @Override
    public void editClienteById(Long id, ClienteModelo clienteModelo) {
        // Comprueba que existe el cliente con el id
        existsClienteById(id);

        logger.info("Editando cliente: {} ", clienteModelo.getNombre());
        clienteRepository.editCliente(
                id,
                clienteModelo.getClave(),
                clienteModelo.isEstado(),
                clienteModelo.getNombre(),
                clienteModelo.getGenero(),
                clienteModelo.getEdad(),
                clienteModelo.getIdentificacion(),
                clienteModelo.getDireccion(),
                clienteModelo.getTelefono()
        );
    }
    
    private void existsByIdentificacion(String identificacion) {
        if (clienteRepository.existsByIdentificacion(identificacion)) {
            logger.error("El usuario con la identificacion {} ya existe.", identificacion);
            throw new AlreadyExistsException();
        }
    }

    private void existsClienteById(Long id) {
        if (!clienteRepository.existsById(id)) {
            logger.error("No se encontró un cliente con el id {}", id);
            throw new NoDataFoundException();
        }
    }
}