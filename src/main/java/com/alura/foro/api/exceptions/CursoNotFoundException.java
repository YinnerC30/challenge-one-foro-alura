package com.alura.foro.api.exceptions;
public class CursoNotFoundException extends RuntimeException {

    private Long id;

    public CursoNotFoundException(Long id) {
        super("El curso con ID " + id + " no se encuentra");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
