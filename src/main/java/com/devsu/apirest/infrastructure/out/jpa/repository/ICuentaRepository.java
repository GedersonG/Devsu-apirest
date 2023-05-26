package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository<CuentaEntidad, String> {
}
