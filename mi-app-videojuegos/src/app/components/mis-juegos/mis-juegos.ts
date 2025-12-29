import { Component, inject, signal, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-mis-juegos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './mis-juegos.html',
  styleUrl: './mis-juegos.css'
})
export class MisJuegos implements OnInit {
  http = inject(HttpClient);

  videojuegos = signal<any[]>([]);


  ngOnInit() {
    this.obtenerMisJuegos();
  }

  obtenerMisJuegos() {
    const auth = localStorage.getItem('auth');
    
    if (!auth) {
      alert("No estás identificado. Vuelve al login.");
      return;
    }

    this.http.get<any[]>('http://localhost:8080/api/videojuegos/todos', {
      headers: { 'Authorization': auth }
    }).subscribe({
      next: (datos) => {
        this.videojuegos.set(datos);
      },
      error: (err) => {
        console.error("Error al cargar juegos", err);
        alert("Sesión caducada o error de servidor");
      }
    });
  }
}