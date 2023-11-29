package com.alura.foro.exceptions;
public class RespuestaNotFoundException extends RuntimeException {

    private Long id;

    public RespuestaNotFoundException(Long id) {
        super("La respuesta con ID " + id + " no se encuentra");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
