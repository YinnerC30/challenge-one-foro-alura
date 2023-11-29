package com.alura.foro.modelo.usuario;

public record DatosRegistroUsuario(
        String nombre,
        String email,
        String contrasena,
        Boolean is_active
) {
}
