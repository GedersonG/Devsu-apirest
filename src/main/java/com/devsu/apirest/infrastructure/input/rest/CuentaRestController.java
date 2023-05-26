package com.devsu.apirest.infrastructure.input.rest;

import com.devsu.apirest.application.dto.request.CuentaRequestDto;
import com.devsu.apirest.application.dto.response.CuentaResponseDto;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Void> saveCuenta(@Valid @RequestBody CuentaRequestDto cuentaRequestDto) {
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
    public ResponseEntity<List<CuentaResponseDto>> getAllCuentas() {
        return ResponseEntity.ok(cuentaHandler.getAllCuentas());
    }
}
