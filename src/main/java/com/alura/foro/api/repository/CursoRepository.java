package com.alura.foro.api.repository;

import com.alura.foro.api.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("SELECT t FROM Curso t WHERE t.is_active = true")
    Page<Curso> findAllByIsActiveTrue(Pageable pageable);

    @Query("SELECT t FROM Curso t WHERE t.id = :id AND t.is_active = true")
    Optional<Curso> findByIdAndIsActiveTrue(Long id);
}
