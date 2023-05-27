package com.devsu.apirest.infrastructure.exceptionhandler;

import com.devsu.apirest.infrastructure.exception.InsufficientBalanceException;
import com.devsu.apirest.infrastructure.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Map<String, String>> handleInsufficientBalanceException(
            InsufficientBalanceException balanceException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INSUFFICIENT_BALANCE.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleClienteArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName + "-error", errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}