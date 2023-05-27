package com.devsu.apirest.infrastructure.out.jpa.repository;

import com.devsu.apirest.infrastructure.out.jpa.entity.MovimientoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMovimientoRepository extends JpaRepository<MovimientoEntidad, Long> {

    @Query("SELECT SUM(m.valor) FROM MovimientoEntidad m " +
           "WHERE m.fecha = :fecha " +
           "AND m.cuenta.numeroCuenta = :cuenta " +
           "AND m.valor < 0")
    Optional<Integer> sumValorByFecha (@Param("fecha") String fecha, @Param("cuenta") long cuenta);

    //void updateByValor(long valor);

}
