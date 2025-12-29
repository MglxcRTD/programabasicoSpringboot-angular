import { Component, inject, signal, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuarios-admin',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './usuarios-admin.html',
  styleUrl: './usuarios-admin.css',
})
export class UsuarioAdmin implements OnInit {
  http = inject(HttpClient);
  router = inject(Router);
  usuarios = signal<any[]>([]);
  
  ngOnInit()  {
    const auth = localStorage.getItem('auth');
    this.http.get<any[]>('http://localhost:8080/api/usuarios/todos', {
      headers: { 'Authorization' : auth! }
    }).subscribe(datos => this.usuarios.set(datos));
  }

  verJuegoDeUsuario(userId: number) {
    this.router.navigate(['/mis-juegos', userId]);
  }

}
