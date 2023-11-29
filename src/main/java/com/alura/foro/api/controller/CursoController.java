package com.alura.foro.api.controller;

import com.alura.foro.api.exceptions.CursoNotFoundException;
import com.alura.foro.api.curso.Curso;
import com.alura.foro.api.curso.DatosActualizarCurso;
import com.alura.foro.api.curso.DatosListadoCurso;
import com.alura.foro.api.curso.DatosRegistroCurso;
import com.alura.foro.api.repository.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<Curso> guardarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        Curso curso = new Curso(datosRegistroCurso);
        cursoRepository.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }


    @GetMapping
    public Page<DatosListadoCurso> listadoCursos(@PageableDefault(size = 5) Pageable pageable) {
        return cursoRepository.findAll(pageable).map(DatosListadoCurso::new);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> obtenerCurso(@PathVariable Long id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (!cursoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursoOptional);
    }


    @PutMapping
    @Transactional
    public void actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso) throws CursoNotFoundException {
        Optional<Curso> cursoOptional = cursoRepository.findById(datosActualizarCurso.id());
        if (!cursoOptional.isPresent()) {
            throw new CursoNotFoundException(datosActualizarCurso.id());
        }

        Curso curso = cursoOptional.get();
        curso.actualizarDatos(datosActualizarCurso);

        cursoRepository.save(curso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        curso.desactivarCurso();

        //usuarioRepository.delete(usuario);
    }

}
