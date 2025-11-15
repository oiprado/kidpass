import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Authorization } from './authorization.model';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {
  private authorizationUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.authorizationUrl = `${apiUrl}/authorizations`; // Assuming authorization-service is exposed at /authorizations via API Gateway
  }

  getAuthorizations(): Observable<Authorization[]> {
    return this.http.get<Authorization[]>(this.authorizationUrl);
  }
}
