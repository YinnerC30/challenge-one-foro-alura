package com.alura.foro.api.repository;

import com.alura.foro.api.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT t FROM Topico t WHERE t.is_active = true")
    Page<Topico> findAllByIsActiveTrue(Pageable pageable);

    @Query("SELECT t FROM Topico t WHERE t.id = :id AND t.is_active = true")
    Optional<Topico> findByIdAndIsActiveTrue(Long id);

}
