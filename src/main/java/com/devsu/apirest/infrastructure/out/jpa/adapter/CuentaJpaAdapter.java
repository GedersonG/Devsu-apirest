package com.devsu.apirest.infrastructure.out.jpa.adapter;

import com.devsu.apirest.domain.model.CuentaModelo;
import com.devsu.apirest.domain.spi.ICuentaPersistencePort;
import com.devsu.apirest.infrastructure.exception.NoDataFoundException;
import com.devsu.apirest.infrastructure.out.jpa.entity.ClienteEntidad;
import com.devsu.apirest.infrastructure.out.jpa.entity.CuentaEntidad;
import com.devsu.apirest.infrastructure.out.jpa.mapper.IClienteEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.mapper.ICuentaEntityMapper;
import com.devsu.apirest.infrastructure.out.jpa.repository.IClienteRepository;
import com.devsu.apirest.infrastructure.out.jpa.repository.ICuentaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CuentaJpaAdapter implements ICuentaPersistencePort {

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
        cuenta.setCliente(clienteEntityMapper.toClienteModelo(cliente));

        CuentaEntidad cuentaEntidad = cuentaRepository.save(
                cuentaEntityMapper.toEntity(cuenta)
        );

        return cuentaEntityMapper.toCuentaModelo(cuentaEntidad);
    }

    @Override
    public List<CuentaModelo> getAllCuentas() {
        List<CuentaEntidad> entityList = cuentaRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return cuentaEntityMapper.toCuentaModeloList(entityList);
    }

    @Override
    public boolean existsCuentaById(long id) {
        return cuentaRepository.existsById(id);
    }

    @Override
    public CuentaModelo getCuentaById(long id) {
        CuentaEntidad cuenta =
                cuentaRepository.findById(id).orElseThrow(NoDataFoundException::new);
        return cuentaEntityMapper.toCuentaModelo(cuenta);
    }

    @Override
    public void deleteCuentaById(long id) {
        if (!existsCuentaById(id)) {
            throw new NoDataFoundException();
        }
        cuentaRepository.deleteById(id);
    }

    @Override
    public void updateCuentaById(long id, CuentaModelo cuentaModelo) {
        CuentaModelo cuenta = getCuentaById(id);

        cuenta.setSaldoInicial(cuentaModelo.getSaldoInicial());

        cuentaRepository.save(cuentaEntityMapper.toEntity(cuenta));
    }

    @Override
    public void editCuentaById(long id, CuentaModelo cuentaModelo) {
        CuentaModelo cuentaBefore = getCuentaById(id);

        cuentaRepository.delete(cuentaEntityMapper.toEntity(cuentaBefore));

        saveCuenta(cuentaModelo);
    }
}
