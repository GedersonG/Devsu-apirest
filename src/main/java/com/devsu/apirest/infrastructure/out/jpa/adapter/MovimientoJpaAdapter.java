package com.devsu.apirest.infrastructure.out.jpa.adapter;

import com.devsu.apirest.domain.model.MovimientoModelo;
import com.devsu.apirest.domain.spi.IMovimientoPersistencePort;
import com.devsu.apirest.infrastructure.exception.DailyQuotaExceededException;
import com.devsu.apirest.infrastructure.exception.InsufficientBalanceException;
import com.devsu.apirest.infrastructure.exception.NoDataFoundException;
import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import com.devsu.apirest.infrastructure.out.jpa.entity.MovimientoEntidad;
import com.devsu.apirest.infrastructure.out.jpa.mapper.ICuentaEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IMovimientoEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.ICuentaRepository;
import com.devsu.apirest.infrastructure.out.jpa.repository.IMovimientoRepository;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class MovimientoJpaAdapter implements IMovimientoPersistencePort {

    private final ICuentaRepository cuentaRepository;
    private final IMovimientoRepository movimientoRepository;
    private final ICuentaEntityMapper cuentaEntityMapper;
    private final IMovimientoEntityMapper movimientoEntityMapper;

    @Override
    public MovimientoModelo saveMovimiento(MovimientoModelo movimiento) {

        // Operaciones de verificacion de datos de entrada
        CuentaEntidad cuenta = operationsVerify(
                movimiento.getCuenta().getSaldoInicial(),
                movimiento.getValor(),
                movimiento.getCuenta().getNumeroCuenta()
        );

        // Operaciones para el calculo del movimiento y asignacion de valores
        calculateMovimiento(movimiento, cuenta);

        // Guardar movimiento y registro en la cuenta
        cuentaRepository.save(cuenta);
        MovimientoEntidad movimientoEntidad = movimientoRepository.save(
                movimientoEntityMapper.toEntity(movimiento)
        );

        return movimientoEntityMapper.toMovimientoModelo(movimientoEntidad);
    }

    @Override
    public List<MovimientoModelo> getAllMovimientos() {
        List<MovimientoEntidad> entityList = movimientoRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return movimientoEntityMapper.toMovimientoModeloList(entityList);
    }

    @Override
    public boolean existsMovimientoById(long id){
        return movimientoRepository.existsById(id);
    }
    @Override
    public MovimientoModelo getMovimientoById(long id){
        MovimientoEntidad movimiento =
                movimientoRepository.findById(id).orElseThrow(NoDataFoundException::new);
        return movimientoEntityMapper.toMovimientoModelo(movimiento);
    }

    @Override
    public void deleteMovimientoById(long id){
        if (!existsMovimientoById(id)) {
            throw new NoDataFoundException();
        }
        movimientoRepository.deleteById(id);
    }

    @Override
    public void updateMovimientoById(long id, MovimientoModelo movimientoModelo){
        MovimientoModelo movimiento = getMovimientoById(id);

        movimiento.setValor(movimientoModelo.getValor());

        movimientoRepository.save(movimientoEntityMapper.toEntity(movimiento));
    }

    @Override
    public void editMovimientoById(long id, MovimientoModelo movimientoModelo){
        MovimientoModelo movimientoBefore = getMovimientoById(id);

        movimientoRepository.delete(movimientoEntityMapper.toEntity(movimientoBefore));

        saveMovimiento(movimientoModelo);
    }

    private CuentaEntidad verifyAccount(long numeroCuenta) {

        // Verifica que la cuenta existe y la retorna
        return cuentaRepository
                .findById(numeroCuenta)
                .orElseThrow(NoDataFoundException::new);
    }

    private String getFechaToday() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    private int getValorTotalToday(long cuenta) {

        // Obtiene el monto total de retiro de HOY
        return movimientoRepository
                .sumValorByFecha(getFechaToday(), cuenta).orElse(0);
    }

    private void verifyQuota(long numeroCuenta, long valor) {

        //Verifica si la cuota ya excedió o va a exceder en caso de retiro.
        if (
                getValorTotalToday(numeroCuenta)
                        == -1000 ||
                valor + getValorTotalToday(numeroCuenta)
                        < -1000
        ) {
            throw new DailyQuotaExceededException();
        }
    }

    private void verifyBalance(long saldoInicial, long valor) {
        if (saldoInicial + valor < 0) {
            throw new InsufficientBalanceException();
        }
    }

    private CuentaEntidad operationsVerify(long saldoInicial, long valor, long numeroCuenta) {

        //Verifica que la cuenta existe
        CuentaEntidad cuenta = verifyAccount(numeroCuenta);

        // Verficar si hay saldo disponible en caso de retiro
        verifyBalance(saldoInicial, valor);

        // Verificar si excede cupo maximo diario
        verifyQuota(saldoInicial, valor);

        return cuenta;
    }

    private void calculateMovimiento(
            MovimientoModelo movimiento,
            CuentaEntidad cuenta
    ) {

        // Se asigna la cuenta al movimiento
        movimiento.setCuenta(
                cuentaEntityMapper.toCuentaModelo(cuenta)
        );

        // Insertar fecha HOY
        movimiento.setFecha(getFechaToday());

        // Añadir retiro o deposito y calcular nuevo saldo
        movimiento.setTipo(movimiento.getValor() < 0 ? "Retiro" : "Deposito");
        movimiento.setSaldo(
                movimiento.getCuenta().getSaldoInicial() +
                        movimiento.getValor()
        );

        // Actualizar saldo inicial de la cuenta
        cuenta.setSaldoInicial(movimiento.getSaldo());
    }
}