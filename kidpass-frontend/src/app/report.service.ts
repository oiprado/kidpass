import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Report } from './report.model';

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  private reportUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.reportUrl = `${apiUrl}/reports`; // Assuming reporting-service is exposed at /reports via API Gateway
  }

  getReports(): Observable<Report[]> {
    return this.http.get<Report[]>(this.reportUrl);
  }
}
