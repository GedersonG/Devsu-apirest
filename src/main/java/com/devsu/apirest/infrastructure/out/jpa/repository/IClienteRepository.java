package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<ClienteEntidad, Long> {

    @Modifying
    @Query(
            "UPDATE ClienteEntidad c SET " +
            "c.nombre = COALESCE(:nombre, c.nombre), " +
            "c.direccion = COALESCE(:direccion, c.direccion), " +
            "c.telefono = COALESCE(:telefono, c.telefono) " +
            "WHERE c.clienteId = :clienteId"
    )
    void updateCliente(
            @Param("clienteId") Long clienteId,
            @Param("nombre") String nombre,
            @Param("direccion") String direccion,
            @Param("telefono") String telefono
    );

    @Modifying
    @Query(
            "UPDATE ClienteEntidad c SET " +
            "c.clave = COALESCE(:clave, c.clave), " +
            "c.estado = COALESCE(:estado, c.estado), " +
            "c.nombre = COALESCE(:nombre, c.nombre), " +
            "c.genero = COALESCE(:genero, c.genero), " +
            "c.edad = COALESCE(:edad, c.edad), " +
            "c.identificacion = COALESCE(:identificacion, c.identificacion), " +
            "c.direccion = COALESCE(:direccion, c.direccion), " +
            "c.telefono = COALESCE(:telefono, c.telefono) " +
            "WHERE c.clienteId = :clienteId"
    )
    void editCliente(
            @Param("clienteId") Long clienteId,
            @Param("clave") String clave,
            @Param("estado") Boolean estado,
            @Param("nombre") String nombre,
            @Param("genero") String genero,
            @Param("edad") int edad,
            @Param("identificacion") String identificacion,
            @Param("direccion") String direccion,
            @Param("telefono") String telefono
    );

    Optional<ClienteEntidad> findClienteEntidadByIdentificacion (String identificacion);
    boolean existsByIdentificacion(String identificacion);
}