package com.devsu.apirest.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No se encontraron datos asociados a la peticion requerida");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}