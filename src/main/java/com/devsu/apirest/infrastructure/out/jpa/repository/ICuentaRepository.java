package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICuentaRepository extends JpaRepository<CuentaEntidad, Long> {

    @Query("SELECT c FROM CuentaEntidad c " +
           "JOIN c.cliente cl " +
           "WHERE cl.identificacion = :identificacion")
    List<CuentaEntidad> findAllByIdentificacion(String identificacion);
}