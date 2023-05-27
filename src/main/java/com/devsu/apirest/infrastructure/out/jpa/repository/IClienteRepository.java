package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteEntidad, Long> {
    Optional<ClienteEntidad> findClienteEntidadByIdentificacion (String identificacion);
}