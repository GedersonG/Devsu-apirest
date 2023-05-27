package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<ClienteEntidad, Long> {
    Optional<ClienteEntidad> findClienteEntidadByIdentificacion (String identificacion);
}