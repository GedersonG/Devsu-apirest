package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.MovimientoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMovimientoRepository extends JpaRepository<MovimientoEntidad, Long> {

    @Modifying
    @Query(
            "UPDATE MovimientoEntidad m " +
            "SET m.valor = COALESCE(:valor, m.valor) " +
            "WHERE m.movimientoId = :movimientoId"
    )
    void updateMovimientoValor(
            @Param("movimientoId") Long movimientoId,
            @Param("valor") long valor
    );

    @Modifying
    @Query(
            "UPDATE MovimientoEntidad m SET " +
            "m.fecha = COALESCE(:fecha, m.fecha), " +
            "m.tipo = COALESCE(:tipo, m.tipo), " +
            "m.valor = COALESCE(:valor, m.valor), " +
            "m.saldo = COALESCE(:saldo, m.saldo) " +
            "WHERE m.movimientoId = :movimientoId"
    )
    void editMovimiento(
            @Param("movimientoId") Long movimientoId,
            @Param("fecha") String fecha,
            @Param("tipo") String tipo,
            @Param("valor") long valor,
            @Param("saldo") long saldo
    );

    @Query(
           "SELECT SUM(m.valor) FROM MovimientoEntidad m " +
           "WHERE m.fecha = :fecha " +
           "AND m.cuenta.numeroCuenta = :cuenta " +
           "AND m.valor < 0"
    )
    Optional<Integer> sumValorByFecha (
            @Param("fecha") String fecha,
            @Param("cuenta") long cuenta
    );

    @Query(
            "SELECT m.fecha " +
            "AS fecha, c.numeroCuenta " +
            "AS numeroCuenta, c.tipoCuenta " +
            "AS tipoCuenta, c.saldoInicial " +
            "AS saldoInicial, m.valor " +
            "AS valor, m.saldo " +
            "AS saldo, cl.nombre " +
            "AS nombre " +
            "FROM MovimientoEntidad m " +
            "JOIN m.cuenta c " +
            "JOIN c.cliente cl " +
            "WHERE m.fecha = :fecha AND cl.identificacion = :identificacion"
    )
    List<Object[]> getReporte(
            String identificacion,
            String fecha
    );
}
