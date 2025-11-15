import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private authUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.authUrl = `${apiUrl}/auth`; // Assuming auth-service is exposed at /auth via API Gateway
  }

  login(credentials: any): Observable<any> {
    return this.http.post(`${this.authUrl}/login`, credentials);
  }

  register(user: any): Observable<any> {
    return this.http.post(`${this.authUrl}/register`, user);
  }

  // Helper to save token (e.g., in localStorage)
  saveToken(token: string): void {
    localStorage.setItem('jwt_token', token);
  }

  // Helper to get token
  getToken(): string | null {
    return localStorage.getItem('jwt_token');
  }

  // Helper to remove token
  removeToken(): void {
    localStorage.removeItem('jwt_token');
  }

  // Check if user is logged in
  isLoggedIn(): boolean {
    return !!this.getToken();
  }
}
