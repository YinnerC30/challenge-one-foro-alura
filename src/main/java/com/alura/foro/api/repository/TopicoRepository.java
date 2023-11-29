package com.alura.foro.api.repository;

import com.alura.foro.api.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
