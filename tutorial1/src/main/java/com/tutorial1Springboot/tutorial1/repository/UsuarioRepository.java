package com.tutorial1Springboot.tutorial1.repository;

import com.tutorial1Springboot.tutorial1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
