package com.devsu.apirest.application.handler;

import com.devsu.apirest.application.dto.request.ClienteRequestDto;
import com.devsu.apirest.application.dto.request.ClienteUpdateRequestDto;
import com.devsu.apirest.application.dto.response.ClienteResponseDto;

import java.util.List;

public interface IClienteHandler {

    void saveCliente(ClienteRequestDto clienteRequestDto);

    List<ClienteResponseDto> getAllClientes();

    void deleteClienteById(long id);

    ClienteResponseDto getClienteById(long id);

    void updateClienteById(long id, ClienteUpdateRequestDto clienteUpdateRequestDto);

    void editClienteById(long id, ClienteRequestDto clienteRequestDto);
}