import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Booking {
  id: string;
  activityName: string;
  bookingDate: string;
  status: string;
  numberOfStudents: number;
}

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private bookingUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.bookingUrl = `${apiUrl}/bookings`; // Assuming booking-service is exposed at /bookings via API Gateway
  }

  getBookings(): Observable<Booking[]> {
    return this.http.get<Booking[]>(this.bookingUrl);
  }
}
