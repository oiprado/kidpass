import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Notification } from './notification.model';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  private notificationUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.notificationUrl = `${apiUrl}/notifications`; // Assuming notification-service is exposed at /notifications via API Gateway
  }

  getNotifications(): Observable<Notification[]> {
    return this.http.get<Notification[]>(this.notificationUrl);
  }
}
