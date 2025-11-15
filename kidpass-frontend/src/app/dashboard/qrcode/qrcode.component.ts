import { Component } from '@angular/core';
import { QrCodeService } from '../../qrcode.service';
import { QrCode } from '../../qrcode.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-qrcode',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './qrcode.component.html',
  styleUrl: './qrcode.component.css'
})
export class QrCodeComponent {
  authorizationId: string = '';
  qrCode: QrCode | null = null;
  errorMessage: string | null = null;

  constructor(private qrCodeService: QrCodeService) { }

  generateQrCode(): void {
    if (this.authorizationId) {
      this.qrCodeService.generateQrCode(this.authorizationId).subscribe({
        next: (qrCode) => {
          this.qrCode = qrCode;
          this.errorMessage = null;
        },
        error: (error) => {
          this.qrCode = null;
          this.errorMessage = 'Error generating QR code.';
          console.error('Error generating QR code:', error);
        }
      });
    }
  }
}
