package com.devsu.apirest.infrastructure.out.jpa.adapter;

import com.devsu.apirest.domain.model.CuentaModelo;
import com.devsu.apirest.domain.spi.ICuentaPersistencePort;
import com.devsu.apirest.infrastructure.exception.AlreadyExistsException;
import com.devsu.apirest.infrastructure.exception.NoDataFoundException;
import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IClienteEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.mapper.ICuentaEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.IClienteRepository;
import com.devsu.apirest.infrastructure.out.jpa.repository.ICuentaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CuentaJpaAdapter implements ICuentaPersistencePort {

    private static final Logger logger = LoggerFactory.getLogger(CuentaJpaAdapter.class);
    private final ICuentaRepository cuentaRepository;
    private final IClienteRepository clienteRepository;
    private final ICuentaEntityMapper cuentaEntityMapper;
    private final IClienteEntityMapper clienteEntityMapper;

    @Override
    public CuentaModelo saveCuenta(CuentaModelo cuenta) {
        // Obtener el cliente por documento
        ClienteEntidad cliente =
                clienteRepository.findClienteEntidadByIdentificacion(
                        cuenta.getCliente().getIdentificacion()
                ).orElseThrow(NoDataFoundException::new);
        logger.info("Cliente obtenido: {}", cliente.getNombre());
        cuenta.setCliente(clienteEntityMapper.toClienteModelo(cliente));

        verifyAccounts(cuenta.getCliente().getIdentificacion(), cuenta.getTipoCuenta());

        CuentaEntidad cuentaEntidad = cuentaRepository.save(
                cuentaEntityMapper.toEntity(cuenta)
        );
        logger.info("Se creó la cuenta con el número: {}", cuentaEntidad.getNumeroCuenta());
        return cuentaEntityMapper.toCuentaModelo(cuentaEntidad);
    }

    private void verifyAccounts(String identificacion, String tipoCuenta) {
        logger.info("Verificando cuenta...");
        List<CuentaEntidad> cuentas = cuentaRepository.findAllByIdentificacion(identificacion);

        for(CuentaEntidad cuenta : cuentas) {
            if (Objects.equals(cuenta.getTipoCuenta(), tipoCuenta)) {
                logger.error("Ya existe una cuenta de {} para esa persona.", tipoCuenta);
                throw new AlreadyExistsException();
            }
        }
    }

    @Override
    public List<CuentaModelo> getAllCuentas() {
        List<CuentaEntidad> entityList = cuentaRepository.findAll();
        if (entityList.isEmpty()) {
            logger.error("No se encontraron cuentas.");
            throw new NoDataFoundException();
        }
        return cuentaEntityMapper.toCuentaModeloList(entityList);
    }

    private void existsCuentaById(long id) {
        if (!cuentaRepository.existsById(id)) {
            logger.error("No existe una cuenta el con id {}", id);
            throw new NoDataFoundException();
        }
    }

    @Override
    public CuentaModelo getCuentaById(long id) {
        CuentaEntidad cuenta =
                cuentaRepository.findById(id).orElseThrow(NoDataFoundException::new);
        return cuentaEntityMapper.toCuentaModelo(cuenta);
    }

    @Override
    public void deleteCuentaById(long id) {
        //Comprueba si la cuenta existe
        existsCuentaById(id);

        logger.warn("Eliminando cuenta con el id {}.", id);
        cuentaRepository.deleteById(id);
    }

    @Override
    public void updateCuentaById(long id, CuentaModelo cuentaModelo) {
        // Comprueba si la cuenta existe
        existsCuentaById(id);

        logger.info("Actualizando cuenta # {}.", id);
        cuentaRepository.updateSaldoInicial(id, cuentaModelo.getSaldoInicial());
    }

    @Override
    public void editCuentaById(long id, CuentaModelo cuentaModelo) {
        //Comprueba si la cuenta existe
        existsCuentaById(id);

        logger.info("Editando cuenta # {}", id);
        cuentaRepository.editCuenta(
                id,
                cuentaModelo.getSaldoInicial(),
                cuentaModelo.getTipoCuenta(),
                cuentaModelo.isEstado(),
                clienteEntityMapper.toEntity(cuentaModelo.getCliente())
        );
    }
}
