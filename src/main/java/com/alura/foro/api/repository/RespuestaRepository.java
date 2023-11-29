package com.alura.foro.api.repository;

import com.alura.foro.api.respuesta.Respuesta;
import com.alura.foro.api.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    @Query("SELECT t FROM Respuesta t WHERE t.is_active = true")
    Page<Respuesta> findAllByIsActiveTrue(Pageable pageable);

    @Query("SELECT t FROM Respuesta t WHERE t.id = :id AND t.is_active = true")
    Optional<Respuesta> findByIdAndIsActiveTrue(Long id);
}
