package com.devsu.apirest.infrastructure.input.rest;

import com.devsu.apirest.application.dto.request.movimiento.MovimientoRequestDto;
import com.devsu.apirest.application.dto.request.movimiento.MovimientoUpdateRequestDto;
import com.devsu.apirest.application.dto.response.movimiento.MovimientoResponseDto;
import com.devsu.apirest.application.handler.IMovimientoHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoRestController {

    private final IMovimientoHandler movimientoHandler;

    @Operation(summary = "Agregar una nueva movimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movimiento creada", content = @Content),
            @ApiResponse(responseCode = "409", description = "Movimiento ya existe", content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Void> saveMovimiento (@Valid @RequestBody MovimientoRequestDto movimientoRequestDto) {
        movimientoHandler.saveMovimiento(movimientoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todas las movimientos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todas las movimientos retornadas",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MovimientoResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<MovimientoResponseDto>> getAllMovimientos () {
        return ResponseEntity.ok(movimientoHandler.getAllMovimientos());
    }

    @Operation(summary = "Obtener movimiento por numero de movimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movimiento retornada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovimientoResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoResponseDto> getMovimientoById (@PathVariable("id") long id) {
        return ResponseEntity.ok(movimientoHandler.getMovimientoById(id));
    }

    @Operation(summary = "Borra un movimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movimiento eliminada", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movimiento no existe", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimientoById (@PathVariable("id") long id) {
        movimientoHandler.deleteMovimientoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Edita a un movimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movimiento editada", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movimiento no existe", content = @Content)
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editMovimientoById (
            @PathVariable("id") long id,
            @RequestBody MovimientoRequestDto movimientoRequestDto
    ) {
        movimientoHandler.editMovimientoById(id, movimientoRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Actualiza a un movimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movimiento actualizada", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movimiento no existe", content = @Content)
    })
    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateMovimientoById (
            @PathVariable("id") long id,
            @RequestBody MovimientoUpdateRequestDto movimientoUpdateRequestDto
    ) {
        movimientoHandler.updateMovimientoById(id, movimientoUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
