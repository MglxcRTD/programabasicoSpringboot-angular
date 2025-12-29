package com.tutorial1Springboot.tutorial1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "videojuegos")
@Data
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String plataforma;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
