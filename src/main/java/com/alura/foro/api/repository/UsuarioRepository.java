package com.alura.foro.api.repository;

import com.alura.foro.api.topico.Topico;
import com.alura.foro.api.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT t FROM Usuario t WHERE t.is_active = true")
    Page<Usuario> findAllByIsActiveTrue(Pageable pageable);

    @Query("SELECT t FROM Usuario t WHERE t.id = :id AND t.is_active = true")
    Optional<Usuario> findByIdAndIsActiveTrue(Long id);
}
