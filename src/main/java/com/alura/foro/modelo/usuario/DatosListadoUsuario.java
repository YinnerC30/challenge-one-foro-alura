package com.alura.foro.modelo.usuario;

public record DatosListadoUsuario(
        Long id,
        String nombre,
        String email,
        Boolean is_active
) {
    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getId(),usuario.getNombre(), usuario.getEmail(), usuario.getIs_active());
    }
}
