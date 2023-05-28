package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICuentaRepository extends JpaRepository<CuentaEntidad, Long> {

    @Modifying
    @Query(
           "UPDATE CuentaEntidad c " +
           "SET c.saldoInicial = :saldoInicial " +
           "WHERE c.numeroCuenta = :numeroCuenta"
    )
    void updateSaldoInicial(
            @Param("numeroCuenta") Long numeroCuenta,
            @Param("saldoInicial") long saldoInicial
    );

    @Modifying
    @Query(
            "UPDATE CuentaEntidad c SET " +
            "c.saldoInicial = COALESCE(:saldoInicial, c.saldoInicial), " +
            "c.tipoCuenta = COALESCE(:tipoCuenta, c.tipoCuenta), " +
            "c.estado = COALESCE(:estado, c.estado), " +
            "c.cliente = COALESCE(:cliente, c.cliente) " +
            "WHERE c.numeroCuenta = :numeroCuenta"
    )
    void editCuenta(
            @Param("numeroCuenta") Long numeroCuenta,
            @Param("saldoInicial") long saldoInicial,
            @Param("tipoCuenta") String tipoCuenta,
            @Param("estado") boolean estado,
            @Param("cliente") ClienteEntidad cliente
    );

    @Query(
           "SELECT c FROM CuentaEntidad c " +
           "JOIN c.cliente cl " +
           "WHERE cl.identificacion = :identificacion"
    )
    List<CuentaEntidad> findAllByIdentificacion(String identificacion);
}