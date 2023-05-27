package com.devsu.apirest.infrastructure.input.rest;

import com.devsu.apirest.application.dto.request.cuenta.CuentaRequestDto;
import com.devsu.apirest.application.dto.request.cuenta.CuentaUpdateRequestDto;
import com.devsu.apirest.application.dto.response.cuenta.CuentaResponseDto;
import com.devsu.apirest.application.handler.ICuentaHandler;
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
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class CuentaRestController {
    
    private final ICuentaHandler cuentaHandler;

    @Operation(summary = "Agregar una nueva cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cuenta creada", content = @Content),
            @ApiResponse(responseCode = "409", description = "Cuenta ya existe", content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Void> saveCuenta (@Valid @RequestBody CuentaRequestDto cuentaRequestDto) {
        cuentaHandler.saveCuenta(cuentaRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todas las cuentas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todas las cuentas retornadas",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CuentaResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<CuentaResponseDto>> getAllCuentas () {
        return ResponseEntity.ok(cuentaHandler.getAllCuentas());
    }

    @Operation(summary = "Obtener cuenta por numero de cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta retornada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CuentaResponseDto> getCuentaById (@PathVariable("id") long id) {
        return ResponseEntity.ok(cuentaHandler.getCuentaById(id));
    }

    @Operation(summary = "Borra un cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cuenta eliminada", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cuenta no existe", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuentaById (@PathVariable("id") long id) {
        cuentaHandler.deleteCuentaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Edita a un cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cuenta editada", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cuenta no existe", content = @Content)
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editCuentaById (
            @PathVariable("id") long id,
            @RequestBody CuentaRequestDto cuentaRequestDto
    ) {
        cuentaHandler.editCuentaById(id, cuentaRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Actualiza a un cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cuenta actualizada", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cuenta no existe", content = @Content)
    })
    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateCuentaById (
            @PathVariable("id") long id,
            @RequestBody CuentaUpdateRequestDto cuentaUpdateRequestDto
    ) {
        cuentaHandler.updateCuentaById(id, cuentaUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
