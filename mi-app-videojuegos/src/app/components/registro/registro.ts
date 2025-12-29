import { HttpClient } from "@angular/common/http";
import { Router, RouterLink } from "@angular/router";
import { Component, inject } from '@angular/core'; 
import { CommonModule } from '@angular/common';   
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink], 
  templateUrl: './registro.html',
  styleUrl: './registro.css'
})

export class Registro {
  http = inject(HttpClient);
  router = inject(Router);

  usuarioForm = {
    username: '',
    password: '',
    rol: 'USUARIO'
  };

  registrarUsuario() {
    this.http.post('http://localhost:8080/api/usuarios/registrar', this.usuarioForm).subscribe({
      next: () => {
        alert("¡Registro éxito! Ahora identifícate.");
        this.router.navigate(['/login']); // Lo mandamos al login tras registrarse
      },
      error: () => alert("Error al registrar")
    });
  }
}