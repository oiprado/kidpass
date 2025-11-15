import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Activity {
  id: string;
  name: string;
  description: string;
  date: string;
  time: string;
  location: string;
}

@Injectable({
  providedIn: 'root'
})
export class ActivityService {
  private activityUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.activityUrl = `${apiUrl}/activities`; // Assuming activity-service is exposed at /activities via API Gateway
  }

  getActivities(): Observable<Activity[]> {
    return this.http.get<Activity[]>(this.activityUrl);
  }
}
