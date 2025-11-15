import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private studentUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.studentUrl = `${apiUrl}/students`; // Assuming student-service is exposed at /students via API Gateway
  }

  getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentUrl);
  }
}
