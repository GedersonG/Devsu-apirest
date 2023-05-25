package com.devsu.apirest.infrastructure.input.rest;

import com.devsu.apirest.application.dto.request.ClienteRequestDto;
import com.devsu.apirest.application.dto.response.ClienteResponseDto;
import com.devsu.apirest.application.handler.IClienteHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteRestController {

    private final IClienteHandler clienteHandler;

    @Operation(summary = "Add a new cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado", content = @Content),
            @ApiResponse(responseCode = "409", description = "Cliente ya existe", content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Void> saveCliente(@Valid @RequestBody ClienteRequestDto clienteRequestDto) {
        clienteHandler.saveCliente(clienteRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All clientes returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClienteResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<ClienteResponseDto>> getAllClientes() {
        return ResponseEntity.ok(clienteHandler.getAllClientes());
    }

}