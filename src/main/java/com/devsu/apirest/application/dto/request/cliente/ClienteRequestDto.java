package com.devsu.apirest.application.dto.request.cliente;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class ClienteRequestDto {

    @NotEmpty(message = "El nombre es obligatorio.")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres.")
    private String nombre;

    @NotEmpty(message = "La direccion es obligatoria.")
    private String direccion;

    @NotEmpty(message = "El numero de telefono es obligatorio.")
    @Pattern(regexp = "^[0-9]{9}$", message = "El número de telefono no es valido.")
    private String telefono;

    @NotEmpty(message = "La contraseña es obligatoria.")
    @Pattern(regexp = "^[0-9]{4}",
            message = "La contraseña debe incluir únicamente números y tener 4 digitos.")
    private String clave;

    @NotEmpty(message = "El número de identificacion es obligatorio.")
    @Size(min = 6, max = 12, message = "Inserte una identificacion válida.")
    @Pattern(regexp = "^[0-9]{6,12}$", message = "El documento solo debe contener números.")
    private String identificacion;

    @Min(value = 18, message = "Debes ser mayor de edad.")
    @Max(value = 200, message = "Edad inválida.")
    private int edad;

    @NotEmpty(message = "El género es obligatorio.")
    private String genero;
}
