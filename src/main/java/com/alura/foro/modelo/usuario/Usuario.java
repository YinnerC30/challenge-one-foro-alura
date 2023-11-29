package com.alura.foro.modelo.usuario;

import com.alura.foro.modelo.usuario.DatosActualizarUsuario;
import com.alura.foro.modelo.usuario.DatosRegistroUsuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Embeddable
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String contrasena;
	private Boolean is_active;

	public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
		this.nombre = datosRegistroUsuario.nombre();
		this.email = datosRegistroUsuario.email();
		this.contrasena = datosRegistroUsuario.contrasena();
		this.is_active = datosRegistroUsuario.is_active();
	}

	public void desactivarUsuario() {
		this.is_active = false;
	}

	public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
		this.nombre = datosActualizarUsuario.nombre();
		this.contrasena = datosActualizarUsuario.contrasena();
	}

}
