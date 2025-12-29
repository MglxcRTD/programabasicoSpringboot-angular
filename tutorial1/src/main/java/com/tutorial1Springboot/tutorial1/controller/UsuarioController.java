package com.tutorial1Springboot.tutorial1.controller;

import com.tutorial1Springboot.tutorial1.model.Usuario;
import com.tutorial1Springboot.tutorial1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        String pwdenciptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(pwdenciptada);

        return usuarioRepository.save(usuario);
    }

    @GetMapping("/todos")
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}
