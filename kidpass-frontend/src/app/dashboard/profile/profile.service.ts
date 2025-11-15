import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface UserProfile {
  id: string;
  firstName: string;
  lastName: string;
  email: string;
  address: string;
  phone: string;
}

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private profileUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.profileUrl = `${apiUrl}/profile`; // Assuming profile-service is exposed at /profile via API Gateway
  }

  getProfile(): Observable<UserProfile> {
    return this.http.get<UserProfile>(this.profileUrl);
  }
}
