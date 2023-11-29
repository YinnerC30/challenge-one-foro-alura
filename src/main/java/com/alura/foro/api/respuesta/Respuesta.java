package com.alura.foro.api.respuesta;

import com.alura.foro.api.topico.Topico;
import com.alura.foro.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @Column(name = "is_solved")
    private Boolean solucion = false;

    @Column(name = "is_active")
    private Boolean isActive = true;

    public void actualizarDatos(Respuesta respuesta) {
        if (respuesta.getMensaje() != null && !respuesta.getMensaje().isEmpty()) {
            this.mensaje = respuesta.getMensaje();
        }

        if (respuesta.getTopico() != null) {
            this.topico = respuesta.getTopico();
        }

        if (respuesta.getFechaCreacion() != null) {
            this.fechaCreacion = respuesta.getFechaCreacion();
        }

        if (respuesta.getAutor() != null) {
            this.autor = respuesta.getAutor();
        }

        if (respuesta.getSolucion() != null) {
            this.solucion = respuesta.getSolucion();
        }
    }


    public void desactivarRespuesta() {
        this.isActive = false;
    }
}
