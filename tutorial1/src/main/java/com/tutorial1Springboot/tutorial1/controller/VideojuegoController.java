package com.tutorial1Springboot.tutorial1.controller;

import com.tutorial1Springboot.tutorial1.model.Rol;
import com.tutorial1Springboot.tutorial1.model.Usuario;
import com.tutorial1Springboot.tutorial1.model.Videojuego;
import com.tutorial1Springboot.tutorial1.repository.UsuarioRepository;
import com.tutorial1Springboot.tutorial1.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
@CrossOrigin(origins = "http://localhost:4200")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/todos")
    public List<Videojuego> listarSegunRol(@AuthenticationPrincipal UserDetails currentUser) {
        String username = currentUser.getUsername();
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));


        if (usuario.getRol().name().equals("ADMINISTRADOR")) {
            return videojuegoService.listartodo();
        } else {

            return videojuegoService.listarporUsuario(usuario.getId());
        }
    }


    @PostMapping("/registrar")
    public Videojuego registrar(@RequestBody Videojuego nuevojuego, @AuthenticationPrincipal UserDetails currentUser) {
       Usuario usuario = usuarioRepository.findByUsername(currentUser.getUsername()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        nuevojuego.setUsuario(usuario);
       return videojuegoService.guardarjuego(nuevojuego);
    }


    @GetMapping("/global")
    public List<Videojuego> listarGlobales() {
        return videojuegoService.listarGlobales();
    }


    @GetMapping("/usuario/{id}")
    public List<Videojuego> listarPorUsuario(@PathVariable Long id) {
        return videojuegoService.listarporUsuario(id);
    }


    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        videojuegoService.eliminarvideojuego(id);
    }

    @PutMapping("/actualizar")
    public Videojuego actualizar(@RequestBody Videojuego videojuego) {
        return videojuegoService.guardarjuego(videojuego);
    }
}