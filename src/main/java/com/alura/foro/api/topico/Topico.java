package com.alura.foro.api.topico;

import com.alura.foro.api.curso.Curso;
import com.alura.foro.api.enums.StatusTopico;
import com.alura.foro.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Embeddable
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING) // Especifica el tipo de enumeración (en este caso, STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    private Boolean is_active;

    public Topico(String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico status, Usuario autor, Curso curso, Boolean is_active) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.is_active = is_active;
    }

    public void desactivarTopico() {
        this.is_active = false;
    }

    public void actualizarDatos(Topico topico) {
        if (topico.getTitulo() != null && !topico.getTitulo().isEmpty()) {
            this.titulo = topico.getTitulo();
        }

        if (topico.getMensaje() != null && !topico.getMensaje().isEmpty()) {
            this.mensaje = topico.getMensaje();
        }

        if (topico.getFechaCreacion() != null) {
            this.fechaCreacion = topico.getFechaCreacion();
        }

        if (topico.getStatus() != null) {
            this.status = topico.getStatus();
        }

        if (topico.getAutor() != null) {
            this.autor = topico.getAutor();
        }

        if (topico.getCurso() != null) {
            this.curso = topico.getCurso();
        }
    }

}
