package com.alura.foro.api.topico;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Integer status,
        Integer autor_id,
        Integer curso_id
) {
}
