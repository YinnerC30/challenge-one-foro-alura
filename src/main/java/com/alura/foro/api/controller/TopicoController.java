package com.alura.foro.api.controller;

import com.alura.foro.api.curso.Curso;
import com.alura.foro.api.curso.DatosActualizarCurso;
import com.alura.foro.api.curso.DatosListadoCurso;
import com.alura.foro.api.curso.DatosRegistroCurso;
import com.alura.foro.api.exceptions.CursoNotFoundException;
import com.alura.foro.api.exceptions.TopicoNotFoundException;
import com.alura.foro.api.repository.CursoRepository;
import com.alura.foro.api.repository.TopicoRepository;
import com.alura.foro.api.topico.Topico;
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
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> guardarTopico(@RequestBody Topico topico) {
        topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topico);
    }

   @GetMapping
    public Page<Topico> listadoCursos(@PageableDefault(size = 5) Pageable pageable) {
        return topicoRepository.findAll(pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Topico>> obtenerTopico(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (!topicoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(topicoOptional);
    }


    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody Topico topico) throws TopicoNotFoundException {
        Optional<Topico> topicoOptional = topicoRepository.findById(topico.getId());
        if (!topicoOptional.isPresent()) {
            throw new CursoNotFoundException(topico.getId());
        }
        topico.actualizarDatos(topico);

        topicoRepository.save(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }

}
