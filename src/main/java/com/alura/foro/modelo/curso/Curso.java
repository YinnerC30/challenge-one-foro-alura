package com.alura.foro.modelo.curso;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String categoria;
	private Boolean is_active;

	public Curso(String nombre, String categoria, Boolean is_active) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.is_active = is_active;
	}

	public Curso(DatosRegistroCurso datosRegistroCurso) {
		this.nombre = datosRegistroCurso.nombre();
		this.categoria = datosRegistroCurso.categoria();
		this.is_active = datosRegistroCurso.is_active();
	}

	public void desactivarCurso() {
		this.is_active = false;
	}

	public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
		this.nombre = datosActualizarCurso.nombre();
		this.categoria = datosActualizarCurso.categoria();
	}
}
