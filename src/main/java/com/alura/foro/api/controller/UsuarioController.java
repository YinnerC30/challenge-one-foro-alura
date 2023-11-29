package com.alura.foro.api.controller;

import com.alura.foro.api.exceptions.UsuarioNotFoundException;
import com.alura.foro.api.usuario.Usuario;
import com.alura.foro.api.usuario.DatosActualizarUsuario;
import com.alura.foro.api.usuario.DatosListadoUsuario;
import com.alura.foro.api.usuario.DatosRegistroUsuario;
import com.alura.foro.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        Usuario usuario = new Usuario(datosRegistroUsuario);
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }


    @GetMapping
    public Page<DatosListadoUsuario> listadoUsuarios(@PageableDefault(size = 5) @SortDefault(sort = "id") Pageable pageable) {
        return usuarioRepository.findAllByIsActiveTrue(pageable).map(DatosListadoUsuario::new);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> obtenerUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByIdAndIsActiveTrue(id);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioOptional);
    }


    @PutMapping
    @Transactional
    public void actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) throws UsuarioNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByIdAndIsActiveTrue(datosActualizarUsuario.id());
        if (!usuarioOptional.isPresent()) {
            throw new UsuarioNotFoundException(datosActualizarUsuario.id());
        }

        Usuario usuario = usuarioOptional.get();
        usuario.actualizarDatos(datosActualizarUsuario);

        usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.desactivarUsuario();

        //usuarioRepository.delete(usuario);
    }

}
