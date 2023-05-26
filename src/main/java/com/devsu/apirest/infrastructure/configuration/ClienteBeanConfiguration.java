package com.devsu.apirest.infrastructure.configuration;

import com.devsu.apirest.domain.api.IClienteServicePort;
import com.devsu.apirest.domain.spi.IClientePersistencePort;
import com.devsu.apirest.domain.usecase.ClienteUseCase;
import com.devsu.apirest.infrastructure.out.jpa.adapter.ClienteJpaAdapter;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IClienteEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ClienteBeanConfiguration {

    private final IClienteRepository clienteRepository;
    private final IClienteEntityMapper clienteEntidadMapper;

    @Bean
    public IClientePersistencePort clientePersistencePort() {
        return new ClienteJpaAdapter(clienteRepository, clienteEntidadMapper);
    }

    @Bean
    public IClienteServicePort clienteServicePort() {
        return new ClienteUseCase(clientePersistencePort());
    }
}