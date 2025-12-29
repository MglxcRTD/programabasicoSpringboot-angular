import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router, RouterLink } from '@angular/router'; 

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink], 
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  http = inject(HttpClient);
  router = inject(Router);


  usuarioForm = {
    username: '',
    password: ''
  };


  iniciarSesion() {
    const authHeader = 'Basic ' + btoa(this.usuarioForm.username + ':' + this.usuarioForm.password);
    
    this.http.get<any[]>('http://localhost:8080/api/videojuegos/todos', {
      headers: { 'Authorization': authHeader }
    }).subscribe({
      next: (datos) => {
        localStorage.setItem('auth', authHeader);
       
        this.router.navigate(['/mis-juegos']); 
        console.log("Login correcto, navegando...");
      },
      error: (err) => alert("Usuario o contraseña incorrectos")
    });
  }
}