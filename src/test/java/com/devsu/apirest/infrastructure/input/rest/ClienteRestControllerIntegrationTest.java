package com.devsu.apirest.infrastructure.input.rest;

import com.devsu.apirest.application.dto.response.cliente.ClienteResponseDto;
import com.devsu.apirest.application.handler.IClienteHandler;
import com.devsu.apirest.factory.FactoryClienteDataTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteRestController.class)
public class ClienteRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClienteHandler clienteHandler;

    @Test
    public void getAllClientes_ShouldReturnClientes() throws Exception {
        // Given
        List<ClienteResponseDto> clientes = FactoryClienteDataTest.getClienteResponseDtoList();

        // When
        when(clienteHandler.getAllClientes()).thenReturn(clientes);

        // Then
        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].clienteId").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Gederson"))
                .andExpect(jsonPath("$[0].direccion").value("Cucuta, Colombia"))
                .andExpect(jsonPath("$[0].edad").value(20))
                .andExpect(jsonPath("$[0].identificacion").value("1004808530"))
                .andExpect(jsonPath("$[0].telefono").value("3136303782"))
                .andExpect(jsonPath("$[0].estado").value(true))
                .andExpect(jsonPath("$[0].genero").value("Masculino"))
                .andExpect(jsonPath("$[1].clienteId").value(2))
                .andExpect(jsonPath("$[1].nombre").value("Jose Lema"))
                .andExpect(jsonPath("$[1].direccion").value("Otavalo sn y principal"))
                .andExpect(jsonPath("$[1].edad").value(30))
                .andExpect(jsonPath("$[1].identificacion").value("5256456448"))
                .andExpect(jsonPath("$[1].telefono").value("123456789"))
                .andExpect(jsonPath("$[1].estado").value(true))
                .andExpect(jsonPath("$[1].genero").value("Masculino"));
    }
}
