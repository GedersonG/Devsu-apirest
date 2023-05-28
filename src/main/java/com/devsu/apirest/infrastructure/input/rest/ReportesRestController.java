package com.devsu.apirest.infrastructure.input.rest;

import com.devsu.apirest.application.dto.response.movimiento.MovimientoResponseDto;
import com.devsu.apirest.application.dto.response.reporte.ReporteResponseDto;
import com.devsu.apirest.application.handler.IMovimientoHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/reportes")
@RestController
@RequiredArgsConstructor
public class ReportesRestController {

    private final IMovimientoHandler movimientoHandler;

    @Operation(summary = "Obtener reportes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reportes retornados",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MovimientoResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No se encontraron datos", content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<ReporteResponseDto>> getAllReportesByIdentificacion (
            @RequestParam("usuario") String identificacion,
            @RequestParam("fecha") String[] fechas
            ) {
        return ResponseEntity.ok(movimientoHandler.getReportesByIdentificacion(identificacion, fechas));
    }
}
