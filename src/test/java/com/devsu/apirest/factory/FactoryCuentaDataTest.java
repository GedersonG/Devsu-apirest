package com.devsu.apirest.factory;

import com.devsu.apirest.application.dto.request.cuenta.CuentaRequestDto;
import com.devsu.apirest.application.dto.response.cuenta.CuentaResponseDto;
import com.devsu.apirest.domain.model.CuentaModelo;

import java.util.ArrayList;
import java.util.List;

public class FactoryCuentaDataTest {

    public static CuentaModelo getCuentaModelo() {
        return new CuentaModelo(
            100000L,
                "Ahorro",
                3000L,
                true,
                FactoryClienteDataTest.getClienteModelo()
        );
    }

    public static List<CuentaModelo> getCuentaModeloList() {
        List<CuentaModelo> cuentaModeloList = new ArrayList<>();

        cuentaModeloList.add(new CuentaModelo(
                100000L,
                "Corriente",
                2000L,
                true,
                FactoryClienteDataTest.getClienteModelo()
                )
        );

        cuentaModeloList.add(new CuentaModelo(
                100001,
                "Corriente",
                500L,
                true,
                FactoryClienteDataTest.getClienteModelo()
                )
        );

        return cuentaModeloList;
    }

    public static CuentaRequestDto getCuentaRequestDto() {
        return CuentaRequestDto.builder()
                .tipoCuenta("Ahorro")
                .saldoInicial(400L)
                .identificacion("1004808530")
                .build();
    }

    public static List<CuentaResponseDto> getCuentaResponseDtoList() {
        List<CuentaResponseDto> cuentaResponseDtoList = new ArrayList<>();

        cuentaResponseDtoList.add(CuentaResponseDto.builder()
                .numeroCuenta("100000")
                .tipoCuenta("Corriente")
                .saldoInicial(200L)
                .estado(true)
                .nombre("Gederson")
                .build()
        );

        cuentaResponseDtoList.add(CuentaResponseDto.builder()
                 .numeroCuenta("100001")
                 .tipoCuenta("Corriente")
                 .saldoInicial(200L)
                 .estado(true)
                 .nombre("Gederson")
                .build());

        return cuentaResponseDtoList;
    }
}
