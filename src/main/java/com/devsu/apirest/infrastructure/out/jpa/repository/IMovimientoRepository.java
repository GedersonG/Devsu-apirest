package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.MovimientoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepository extends JpaRepository<MovimientoEntidad, Long> {
}
