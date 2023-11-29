package com.alura.foro.api.controller;

import com.alura.foro.api.exceptions.CursoNotFoundException;
import com.alura.foro.api.exceptions.TopicoNotFoundException;
import com.alura.foro.api.repository.RespuestaRepository;
import com.alura.foro.api.respuesta.Respuesta;
import com.alura.foro.api.topico.Topico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    public ResponseEntity<Respuesta> guardarRespuesta(@RequestBody Respuesta respuesta) {
        respuestaRepository.save(respuesta);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

   @GetMapping
    public Page<Respuesta> listadoRespuestas(@PageableDefault(size = 5) Pageable pageable) {
        return respuestaRepository.findAll(pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Respuesta>> obtenerTopico(@PathVariable Long id) {
        Optional<Respuesta> respuestaOptional = respuestaRepository.findById(id);
        if (!respuestaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuestaOptional);
    }


    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody Respuesta respuesta) throws TopicoNotFoundException {
        Optional<Respuesta> respuestaOptional = respuestaRepository.findById(respuesta.getId());
        if (!respuestaOptional.isPresent()) {
            throw new CursoNotFoundException(respuesta.getId());
        }
        respuesta.actualizarDatos(respuesta);

        respuestaRepository.save(respuesta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuesta.desactivarRespuesta();
    }

}
