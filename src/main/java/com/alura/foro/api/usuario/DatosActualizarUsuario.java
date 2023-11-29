package com.alura.foro.api.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull
        Long id,
        String nombre,
        String contrasena
) {
}
