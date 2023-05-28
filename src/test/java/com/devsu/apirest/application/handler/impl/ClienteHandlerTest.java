package com.devsu.apirest.application.handler.impl;

import com.devsu.apirest.application.dto.request.cliente.ClienteRequestDto;
import com.devsu.apirest.application.mapper.request.IClienteRequestMapper;
import com.devsu.apirest.application.mapper.response.IClienteResponseMapper;
import com.devsu.apirest.domain.api.IClienteServicePort;
import com.devsu.apirest.domain.model.ClienteModelo;
import com.devsu.apirest.factory.FactoryClienteDataTest;
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
class ClienteHandlerTest {

    @InjectMocks
    ClienteHandler clienteHandler;

    @Mock
    IClienteServicePort clienteServicePort;

    @Mock
    IClienteRequestMapper clienteRequestMapper;

    @Mock
    IClienteResponseMapper clienteResponseMapper;

    @Test
    void mustSaveAClient() {
        //Given
        ClienteRequestDto requestDto = FactoryClienteDataTest.getClienteRequestDto();

        ClienteModelo clienteModelo = FactoryClienteDataTest.getClienteModelo();

        //When
        when(clienteRequestMapper.toCliente(any())).thenReturn(clienteModelo);

        clienteHandler.saveCliente(requestDto);

        //Then
        verify(clienteServicePort).saveCliente(any(ClienteModelo.class));
    }

    @Test
    public void mustGetAllClientes() {
        // Given
        List<ClienteModelo> clientes = FactoryClienteDataTest.getClienteModeloList();

        // When
        when(clienteServicePort.getAllClientes()).thenReturn(clientes);
        when(clienteResponseMapper.toResponseList(clientes)).thenReturn(FactoryClienteDataTest.getClienteResponseDtoList());

        clienteHandler.getAllClientes();

        // Then
        verify(clienteServicePort, times(1)).getAllClientes();
    }
}