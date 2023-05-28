package com.devsu.apirest.application.handler.impl;

import com.devsu.apirest.application.dto.request.cliente.ClienteRequestDto;
import com.devsu.apirest.application.dto.request.cuenta.CuentaRequestDto;
import com.devsu.apirest.application.mapper.request.IClienteRequestMapper;
import com.devsu.apirest.application.mapper.request.ICuentaRequestMapper;
import com.devsu.apirest.application.mapper.response.IClienteResponseMapper;
import com.devsu.apirest.application.mapper.response.ICuentaResponseMapper;
import com.devsu.apirest.domain.api.IClienteServicePort;
import com.devsu.apirest.domain.api.ICuentaServicePort;
import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.domain.model.CuentaModelo;
import com.devsu.apirest.factory.FactoryClienteDataTest;
import com.devsu.apirest.factory.FactoryCuentaDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CuentaHandlerTest {

    @InjectMocks
    CuentaHandler cuentaHandler;

    @Mock
    ICuentaServicePort cuentaServicePort;

    @Mock
    ICuentaRequestMapper cuentaRequestMapper;

    @Mock
    ICuentaResponseMapper cuentaResponseMapper;

    @Test
    void mustSaveAnAccount() {
        //Given
        CuentaRequestDto requestDto = FactoryCuentaDataTest.getCuentaRequestDto();

        CuentaModelo cuentaModelo = FactoryCuentaDataTest.getCuentaModelo();

        //When
        when(cuentaRequestMapper.toCuenta(any())).thenReturn(cuentaModelo);

        cuentaHandler.saveCuenta(requestDto);

        //Then
        verify(cuentaServicePort).saveCuenta(any(CuentaModelo.class));
    }

    @Test
    public void mustGetAllAccounts() {
        // Given
        List<CuentaModelo> cuentas = FactoryCuentaDataTest.getCuentaModeloList();

        // When
        when(cuentaServicePort.getAllCuentas()).thenReturn(cuentas);
        when(cuentaResponseMapper.toResponseList(cuentas)).thenReturn(FactoryCuentaDataTest.getCuentaResponseDtoList());

        cuentaHandler.getAllCuentas();

        // Then
        verify(cuentaServicePort, times(1)).getAllCuentas();
    }
}