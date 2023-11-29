package com.alura.foro.exceptions;
public class UsuarioNotFoundException extends RuntimeException {

    private Long id;

    public UsuarioNotFoundException(Long id) {
        super("El usuario con ID " + id + " no se encuentra");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
