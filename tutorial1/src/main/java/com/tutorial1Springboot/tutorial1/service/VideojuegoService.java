package com.tutorial1Springboot.tutorial1.service;

import com.tutorial1Springboot.tutorial1.model.Videojuego;
import com.tutorial1Springboot.tutorial1.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService {

    @Autowired
    VideojuegoRepository videojuegoRepository;

    public Videojuego guardarjuego(Videojuego juego) {
        juego.setNombre(juego.getNombre().toUpperCase());
        return videojuegoRepository.save(juego);

    }

    public List<Videojuego> listarGlobales() {
        return videojuegoRepository.findByUsuarioIsNull();
    }

    public List<Videojuego> listartodo() {
        return videojuegoRepository.findAll();
    }

    public List<Videojuego> listarporUsuario(Long usuarioId) {
        return videojuegoRepository.findByUsuarioId(usuarioId);
    }

    public void eliminarvideojuego(Long id){
        videojuegoRepository.deleteById(id);
    }
}
