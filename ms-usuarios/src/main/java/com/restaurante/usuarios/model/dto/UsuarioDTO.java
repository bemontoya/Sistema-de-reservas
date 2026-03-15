package com.restaurante.usuarios.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Email(message = "El formato del email no es válido")
    @NotBlank(message = "Ek email es obligatorio")
    private String email;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

}
