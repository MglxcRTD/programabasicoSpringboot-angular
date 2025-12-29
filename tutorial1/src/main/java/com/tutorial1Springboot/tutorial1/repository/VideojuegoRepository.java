package com.tutorial1Springboot.tutorial1.repository;

import com.tutorial1Springboot.tutorial1.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    List<Videojuego> findByUsuarioIsNull();
    List<Videojuego> findByUsuarioUsername(String username);
    List<Videojuego> findByUsuarioId(Long usuarioId);
}
