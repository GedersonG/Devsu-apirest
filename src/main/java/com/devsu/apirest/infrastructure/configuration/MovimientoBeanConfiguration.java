package com.devsu.apirest.infrastructure.configuration;

import com.devsu.apirest.domain.api.IMovimientoServicePort;
import com.devsu.apirest.domain.spi.IMovimientoPersistencePort;
import com.devsu.apirest.domain.usecase.MovimientoUseCase;
import com.devsu.apirest.infrastructure.out.jpa.adapter.MovimientoJpaAdapter;
import com.devsu.apirest.infrastructure.out.jpa.mapper.ICuentaEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IMovimientoEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.ICuentaRepository;
import com.devsu.apirest.infrastructure.out.jpa.repository.IMovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MovimientoBeanConfiguration {

    private final ICuentaRepository cuentaRepository;
    private final IMovimientoRepository movimientoRepository;
    private final ICuentaEntityMapper cuentaEntidadMapper;
    private final IMovimientoEntityMapper movimientoEntityMapper;

    @Bean
    public IMovimientoPersistencePort movimientoPersistencePort() {
        return new MovimientoJpaAdapter(
                cuentaRepository,
                movimientoRepository,
                cuentaEntidadMapper,
                movimientoEntityMapper);
    }

    @Bean
    public IMovimientoServicePort movimientoServicePort() {
        return new MovimientoUseCase(movimientoPersistencePort());
    }
}
