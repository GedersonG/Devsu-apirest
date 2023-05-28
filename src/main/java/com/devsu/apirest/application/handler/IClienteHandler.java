package com.devsu.apirest.application.handler;

import com.devsu.apirest.application.dto.request.cliente.ClienteRequestDto;
import com.devsu.apirest.application.dto.request.cliente.ClienteUpdateRequestDto;
import com.devsu.apirest.application.dto.response.cliente.ClienteResponseDto;

import java.util.List;

public interface IClienteHandler {

    void saveCliente(ClienteRequestDto clienteRequestDto);

    List<ClienteResponseDto> getAllClientes();

    void deleteClienteById(long id);

    ClienteResponseDto getClienteById(long id);

    void updateClienteById(long id, ClienteUpdateRequestDto clienteUpdateRequestDto);

    void editClienteById(long id, ClienteRequestDto clienteRequestDto);
}