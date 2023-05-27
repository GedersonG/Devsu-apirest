package com.devsu.apirest.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No se encontraron datos asociados a la peticion requerida"),
    INSUFFICIENT_BALANCE("Saldo no disponible"),
    DAILY_QUOTA_EXCEEDED("Cupo diario excedido"),
    ALREADY_EXISTS("Ya existe un recurso con esos datos");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}