package com.devsu.apirest.application.handler.impl;

import com.devsu.apirest.application.dto.request.cliente.ClienteRequestDto;
import com.devsu.apirest.application.dto.request.cliente.ClienteUpdateRequestDto;
import com.devsu.apirest.application.dto.response.cliente.ClienteResponseDto;
import com.devsu.apirest.application.handler.IClienteHandler;
import com.devsu.apirest.application.mapper.request.IClienteRequestMapper;
import com.devsu.apirest.application.mapper.response.IClienteResponseMapper;
import com.devsu.apirest.domain.api.IClienteServicePort;
import com.devsu.apirest.domain.model.ClienteModelo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteHandler implements IClienteHandler {

    private final IClienteServicePort clienteServicePort;
    private final IClienteRequestMapper clienteRequestMapper;
    private final IClienteResponseMapper clienteResponseMapper;

    @Override
    public void saveCliente(ClienteRequestDto clienteRequestDto) {
        ClienteModelo clienteModelo = clienteRequestMapper.toCliente(clienteRequestDto);
        clienteModelo.setEstado(true);
        clienteServicePort.saveCliente(clienteModelo);
    }

    @Override
    public List<ClienteResponseDto> getAllClientes() {
        return clienteResponseMapper.toResponseList(clienteServicePort.getAllClientes());
    }

    @Override
    public void deleteClienteById(long id) {
        clienteServicePort.deleteClienteById(id);
    }

    @Override
    public ClienteResponseDto getClienteById(long id) {
        return clienteResponseMapper.toResponse(clienteServicePort.getClienteById(id));
    }

    @Override
    public void updateClienteById(long id, ClienteUpdateRequestDto clienteUpdateRequestDto) {
        clienteServicePort.updateClienteById(
                id,
                clienteRequestMapper.dtoUpdateToCliente(
                        clienteUpdateRequestDto
                )
        );
    }

    @Override
    public void editClienteById(long id, ClienteRequestDto clienteRequestDto) {
        clienteServicePort.editClienteById(id, clienteRequestMapper.toCliente(clienteRequestDto));
    }
}