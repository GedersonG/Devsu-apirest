package com.devsu.apirest.application.handler;

import com.devsu.apirest.application.dto.request.ClienteRequestDto;
import com.devsu.apirest.application.dto.response.ClienteResponseDto;

import java.util.List;

public interface IClienteHandler {

    void saveCliente(ClienteRequestDto clienteRequestDto);

    List<ClienteResponseDto> getAllClientes();
}