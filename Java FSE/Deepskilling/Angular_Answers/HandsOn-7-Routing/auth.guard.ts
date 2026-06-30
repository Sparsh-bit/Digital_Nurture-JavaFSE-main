import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
    private isLoggedIn = false; // Hardcoded for this exercise

    constructor(private router: Router) {}

    canActivate(): boolean {
        if (this.isLoggedIn) {
            return true;
        } else {
            this.router.navigate(['/']);
            return false;
        }
    }
}