package com.devsu.apirest.factory;

import com.devsu.apirest.application.dto.request.cliente.ClienteRequestDto;
import com.devsu.apirest.application.dto.response.cliente.ClienteResponseDto;
import com.devsu.apirest.domain.model.ClienteModelo;

import java.util.ArrayList;
import java.util.List;

public class FactoryClienteDataTest {

    public static ClienteModelo getClienteModelo() {
        return new ClienteModelo(
                "Gederson",
                "Masculino",
                20,
                "1004808530",
                "Mi direccion",
                "3136303782",
                1L,
                "1234",
                true
        );
    }

    public static List<ClienteModelo> getClienteModeloList() {
        List<ClienteModelo> clienteModeloList = new ArrayList<>();

        clienteModeloList.add(new ClienteModelo(
                "Gederson",
                "Masculino",
                20,
                "1004808530",
                "Mi direccion",
                "3136303782",
                1L,
                "1234",
                true
                )
        );

        clienteModeloList.add(new ClienteModelo(
                "Jose Lema",
                "Masculino",
                30,
                "5256456448",
                "Otavalo sn y principal",
                "098254785",
                2L,
                "1234",
                true
        ));

        return clienteModeloList;
    }

    public static ClienteRequestDto getClienteRequestDto() {
        return ClienteRequestDto.builder()
                .nombre("Gederson")
                .direccion("Cucuta, Colombia")
                .telefono("3136303782")
                .clave("1234")
                .identificacion("1004808530")
                .edad(20)
                .genero("Masculino")
                .build();
    }

    public static List<ClienteResponseDto> getClienteResponseDtoList() {
        List<ClienteResponseDto> clienteResponseDtoList = new ArrayList<>();

        clienteResponseDtoList.add(ClienteResponseDto.builder()
                .clienteId(1L)
                .nombre("Gederson")
                .direccion("Cucuta, Colombia")
                .edad(20)
                .identificacion("1004808530")
                .telefono("3136303782")
                .estado(true)
                .genero("Masculino")
                .build()
        );

        clienteResponseDtoList.add(ClienteResponseDto.builder()
                .clienteId(2L)
                .nombre("Jose Lema")
                .direccion("Otavalo sn y principal")
                .edad(30)
                .identificacion("5256456448")
                .telefono("123456789")
                .estado(true)
                .genero("Masculino")
                .build()
        );

        return clienteResponseDtoList;
    }
}
