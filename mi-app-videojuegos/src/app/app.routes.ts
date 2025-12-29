import { Routes } from '@angular/router';

import { Login } from './components/login/login';
import { Registro } from './components/registro/registro';
import { MisJuegos } from './components/mis-juegos/mis-juegos';
import { UsuarioAdmin } from './components/usuarios-admin/usuarios-admin';

export const routes: Routes = [
    { path: 'login', component: Login },
    { path: 'registro', component: Registro },
    { path: 'mis-juegos', component: MisJuegos },
    { path: 'mis-juegos/:id', component: MisJuegos },
    { path: 'usuarios-admin', component: UsuarioAdmin },
    { path: '', redirectTo: '/login', pathMatch: 'full' }
];
