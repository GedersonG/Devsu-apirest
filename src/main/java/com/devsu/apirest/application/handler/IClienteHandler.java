package com.devsu.apirest.application.handler;

import com.devsu.apirest.application.dto.request.ClienteRequestDto;
import com.devsu.apirest.application.dto.request.ClienteUpdateRequestDto;
import com.devsu.apirest.application.dto.response.ClienteResponseDto;
import com.devsu.apirest.application.dto.response.MessageResponseDto;

import java.util.List;

public interface IClienteHandler {

    void saveCliente(ClienteRequestDto clienteRequestDto);

    List<ClienteResponseDto> getAllClientes();

    void deleteClienteById(long id);

    ClienteResponseDto getClienteById(long id);

    boolean existsClienteById(long id);

    void updateClienteById(long id, ClienteUpdateRequestDto clienteUpdateRequestDto); //patch

    void editClienteById(long id, ClienteRequestDto clienteRequestDto); //put
}