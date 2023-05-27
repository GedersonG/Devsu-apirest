package com.devsu.apirest.application.handler.impl;

import com.devsu.apirest.application.dto.request.CuentaRequestDto;
import com.devsu.apirest.application.dto.request.CuentaUpdateRequestDto;
import com.devsu.apirest.application.dto.response.CuentaResponseDto;
import com.devsu.apirest.application.handler.ICuentaHandler;
import com.devsu.apirest.application.mapper.request.ICuentaRequestMapper;
import com.devsu.apirest.application.mapper.response.ICuentaResponseMapper;
import com.devsu.apirest.domain.api.ICuentaServicePort;
import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.domain.model.CuentaModelo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CuentaHandler implements ICuentaHandler {

    private final ICuentaServicePort cuentaServicePort;
    private final ICuentaRequestMapper cuentaRequestMapper;
    private final ICuentaResponseMapper cuentaResponseMapper;

    @Override
    public void saveCuenta(CuentaRequestDto cuentaRequestDto) {
        cuentaServicePort.saveCuenta(adjustCuenta(cuentaRequestDto));
    }

    @Override
    public List<CuentaResponseDto> getAllCuentas() {
        List<CuentaModelo> cuentaModeloList = cuentaServicePort.getAllCuentas();
        List<CuentaResponseDto> cuentaResponseDtoList = cuentaResponseMapper.toResponseList(cuentaServicePort.getAllCuentas());
        for (int i = 0; i < cuentaModeloList.size(); i++) {
            cuentaResponseDtoList.get(i).setNombre(cuentaModeloList.get(i).getCliente().getNombre());
        }
        return cuentaResponseDtoList;
    }

    @Override
    public void deleteCuentaById(long id) {
        cuentaServicePort.deleteCuentaById(id);
    }

    @Override
    public CuentaResponseDto getCuentaById(long id) {
        return cuentaResponseMapper.toResponse(cuentaServicePort.getCuentaById(id));
    }

    @Override
    public void updateCuentaById(long id, CuentaUpdateRequestDto cuentaUpdateRequestDto) {
        cuentaServicePort.updateCuentaById(
                id,
                cuentaRequestMapper.dtoUpdateToCuenta(
                        cuentaUpdateRequestDto
                )
        );
    }

    @Override
    public void editCuentaById(long id, CuentaRequestDto cuentaRequestDto) {
        cuentaServicePort.editCuentaById(id, adjustCuenta(cuentaRequestDto));
    }

    private CuentaModelo adjustCuenta (CuentaRequestDto cuentaRequestDto) {
        CuentaModelo cuentaModelo = cuentaRequestMapper.toCuenta(cuentaRequestDto);

        ClienteModelo clienteModelo = new ClienteModelo();
        clienteModelo.setIdentificacion(cuentaRequestDto.getIdentificacion());

        cuentaModelo.setCliente(clienteModelo);
        cuentaModelo.setEstado(true);

        return cuentaModelo;
    }
}
