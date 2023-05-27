package com.devsu.apirest.infrastructure.configuration;

import com.devsu.apirest.domain.api.ICuentaServicePort;
import com.devsu.apirest.domain.spi.ICuentaPersistencePort;
import com.devsu.apirest.domain.usecase.CuentaUseCase;
import com.devsu.apirest.infrastructure.out.jpa.adapter.ClienteJpaAdapter;
import com.devsu.apirest.infrastructure.out.jpa.adapter.CuentaJpaAdapter;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IClienteEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.mapper.ICuentaEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.IClienteRepository;
import com.devsu.apirest.infrastructure.out.jpa.repository.ICuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CuentaBeanConfiguration {

    private final ICuentaRepository cuentaRepository;
    private final IClienteRepository clienteRepository;
    private final ICuentaEntityMapper cuentaEntidadMapper;
    private final IClienteEntityMapper clienteEntityMapper;

    @Bean
    public ICuentaPersistencePort cuentaPersistencePort() {
        return new CuentaJpaAdapter(
                cuentaRepository,
                clienteRepository,
                cuentaEntidadMapper,
                clienteEntityMapper);
    }

    @Bean
    public ICuentaServicePort cuentaServicePort() {
        return new CuentaUseCase(cuentaPersistencePort());
    }
}
