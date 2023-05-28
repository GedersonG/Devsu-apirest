package com.devsu.apirest.infrastructure.input.rest;

import com.devsu.apirest.application.dto.request.cliente.ClienteRequestDto;
import com.devsu.apirest.application.dto.request.cliente.ClienteUpdateRequestDto;
import com.devsu.apirest.application.dto.response.cliente.ClienteResponseDto;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Operation(summary = "Agregar un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado", content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos", content = @Content),
            @ApiResponse(responseCode = "409", description = "Cliente ya existe", content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Void> saveCliente(@Valid @RequestBody ClienteRequestDto clienteRequestDto) {
        clienteHandler.saveCliente(clienteRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos los clientes retornados",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClienteResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<ClienteResponseDto>> getAllClientes() {
        return ResponseEntity.ok(clienteHandler.getAllClientes());
    }

    @Operation(summary = "Obtener cliente por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente retornado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> getClienteById(@PathVariable("id") long id) {
        return ResponseEntity.ok(clienteHandler.getClienteById(id));
    }

    @Operation(summary = "Borra un cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente eliminado", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente no existe", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable("id") long id) {
        clienteHandler.deleteClienteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Edita a un cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente editado", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente no existe", content = @Content)
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editClienteById(
            @PathVariable("id") long id,
            @Valid @RequestBody ClienteRequestDto clienteRequestDto
    ) {
        clienteHandler.editClienteById(id, clienteRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Actualiza a un cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente actualizado", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente no existe", content = @Content)
    })
    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateClienteById(
            @PathVariable("id") long id,
            @Valid @RequestBody ClienteUpdateRequestDto clienteUpdateRequestDto
    ) {
        clienteHandler.updateClienteById(id, clienteUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}