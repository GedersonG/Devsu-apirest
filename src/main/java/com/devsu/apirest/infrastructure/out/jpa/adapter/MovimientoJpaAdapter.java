package com.devsu.apirest.infrastructure.out.jpa.adapter;

import com.devsu.apirest.domain.model.MovimientoModelo;
import com.devsu.apirest.domain.spi.IMovimientoPersistencePort;
import com.devsu.apirest.infrastructure.exception.InsufficientBalanceException;
import com.devsu.apirest.infrastructure.exception.NoDataFoundException;
import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import com.devsu.apirest.infrastructure.out.jpa.entity.MovimientoEntidad;
import com.devsu.apirest.infrastructure.out.jpa.mapper.ICuentaEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IMovimientoEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.ICuentaRepository;
import com.devsu.apirest.infrastructure.out.jpa.repository.IMovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class MovimientoJpaAdapter implements IMovimientoPersistencePort {

    private final ICuentaRepository cuentaRepository;
    private final IMovimientoRepository movimientoRepository;
    private final ICuentaEntityMapper cuentaEntityMapper;
    private final IMovimientoEntityMapper movimientoEntityMapper;
    private final RestTemplate restTemplate;

    @Override
    public MovimientoModelo saveMovimiento(MovimientoModelo movimiento) {
        // Obtenemos la cuenta por numero de cuenta
        CuentaEntidad cuenta = cuentaRepository.findById(
                        movimiento.getCuentaModelo().getNumeroCuenta()
                ).orElseThrow(NoDataFoundException::new);
        movimiento.setCuentaModelo(
                cuentaEntityMapper.toCuentaModelo(cuenta)
        );
        movimiento.setSaldo(movimiento.getCuentaModelo().getSaldoInicial());

        // Verficar si hay saldo disponible en caso de retiro
        if (movimiento.getValor() - movimiento.getSaldo() < 0) {
            throw new InsufficientBalanceException();
        }

        // Añadir Retiro o Deposito
        movimiento.setTipo(movimiento.getValor() < 0 ? "Retiro" : "Deposito");

        // Calcular nuevo saldo
        movimiento.setSaldo(
                movimiento.getCuentaModelo().getSaldoInicial() +
                        movimiento.getValor()
        );

        // Guardar movimiento
        MovimientoEntidad movimientoEntidad = movimientoRepository.save(
                movimientoEntityMapper.toEntity(movimiento)
        );

        // Actualizar saldo inicial de la cuenta
        cuenta.setSaldoInicial(movimiento.getSaldo());
        cuentaRepository.save(cuenta);

        //movimientoEntidad.getCuenta().setNumeroCuenta(
        //        movimiento.getCuentaModelo().getNumeroCuenta()
        //);
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
    public boolean existsMovimientoById(long id) {
        return movimientoRepository.existsById(id);
    }

    @Override
    public MovimientoModelo getMovimientoById(long id) {
        MovimientoEntidad movimiento =
                movimientoRepository.findById(id).orElseThrow(NoDataFoundException::new);
        return movimientoEntityMapper.toMovimientoModelo(movimiento);
    }

    @Override
    public void deleteMovimientoById(long id) {
        if (!existsMovimientoById(id)) {
            throw new NoDataFoundException();
        }
        movimientoRepository.deleteById(id);
    }

    @Override
    public void updateMovimientoById(long id, MovimientoModelo movimientoModelo) {
        MovimientoModelo movimiento = getMovimientoById(id);

        movimiento.setValor(movimientoModelo.getValor());

        movimientoRepository.save(movimientoEntityMapper.toEntity(movimiento));
    }

    @Override
    public void editMovimientoById(long id, MovimientoModelo movimientoModelo) {

    }

    private CuentaEntidad verifyCuenta (MovimientoModelo movimiento) {
        CuentaEntidad cuenta =
                cuentaRepository.findById(
                        movimiento.getCuentaModelo().getNumeroCuenta()
                ).orElseThrow(NoDataFoundException::new);
        return cuenta;
    }
}
