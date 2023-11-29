package com.alura.foro.api.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria,

        Boolean is_active
) {
}
