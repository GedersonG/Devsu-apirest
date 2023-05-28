package com.devsu.apirest.application.dto.request.cuenta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CuentaUpdateRequestDto {
    private long saldoInicial;

    @JsonCreator
    public CuentaUpdateRequestDto(@JsonProperty("saldoInicial") long saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
}
