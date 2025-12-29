import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet, RouterLink } from "@angular/router";

@Component({
  selector: 'app-root',
 
  imports: [CommonModule, RouterOutlet, RouterLink], 
  templateUrl: './app.html',
  styleUrl: './app.css',
  standalone: true
})
export class App {

  
  cerrarSesion() {
    localStorage.removeItem('auth');
    localStorage.removeItem('userRole');
    window.location.href = '/login'; 
  }
}