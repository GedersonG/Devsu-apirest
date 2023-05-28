package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.MovimientoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMovimientoRepository extends JpaRepository<MovimientoEntidad, Long> {

    @Query("SELECT SUM(m.valor) FROM MovimientoEntidad m " +
           "WHERE m.fecha = :fecha " +
           "AND m.cuenta.numeroCuenta = :cuenta " +
           "AND m.valor < 0")
    Optional<Integer> sumValorByFecha (@Param("fecha") String fecha, @Param("cuenta") long cuenta);

    @Query("SELECT m.fecha AS fecha, c.numeroCuenta AS numeroCuenta, c.tipoCuenta AS tipoCuenta, c.saldoInicial AS saldoInicial, " +
            "m.valor AS valor, m.saldo AS saldo, cl.nombre AS nombre " +
            "FROM MovimientoEntidad m " +
            "JOIN m.cuenta c " +
            "JOIN c.cliente cl " +
            "WHERE m.fecha = :fecha AND cl.identificacion = :identificacion")
    List<Object[]> getReporte(String identificacion, String fecha);

}
