package com.alura.foro.exceptions;
public class TopicoNotFoundException extends RuntimeException {

    private Long id;

    public TopicoNotFoundException(Long id) {
        super("El topico con ID " + id + " no se encuentra");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
