import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QrCode } from './qrcode.model';

@Injectable({
  providedIn: 'root'
})
export class QrCodeService {
  private qrCodeUrl: string;

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) {
    this.qrCodeUrl = `${apiUrl}/qrcodes`; // Assuming qr-service is exposed at /qrcodes via API Gateway
  }

  generateQrCode(authorizationId: string): Observable<QrCode> {
    return this.http.post<QrCode>(`${this.qrCodeUrl}/generate`, { authorizationId });
  }

  validateQrCode(qrCodeId: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.qrCodeUrl}/validate/${qrCodeId}`, {});
  }
}
