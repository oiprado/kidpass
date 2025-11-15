import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QrCodeService } from '../qrcode.service';
import { SharedModule } from '../shared/shared.module';
import { ZXingScannerComponent } from '@zxing/ngx-scanner'; // Import as type
import { BarcodeFormat } from '@zxing/library'; // Import BarcodeFormat

@Component({
  selector: 'app-scanner',
  standalone: true,
  imports: [CommonModule, SharedModule],
  templateUrl: './scanner.component.html',
  styleUrl: './scanner.component.css'
})
export class ScannerComponent implements OnInit {
  @ViewChild('scanner')
  scanner!: ZXingScannerComponent;

  scannerEnabled = false;
  qrResult: string | null = null;
  validationStatus: string | null = null;
  errorMessage: string | null = null;

  availableDevices: MediaDeviceInfo[] = [];
  selectedDevice: MediaDeviceInfo | undefined = undefined; // Changed to undefined

  // Expose BarcodeFormat to the template
  BarcodeFormat = BarcodeFormat;

  constructor(private qrCodeService: QrCodeService) { }

  ngOnInit(): void {
    // Request camera permissions when the component initializes
    navigator.mediaDevices.getUserMedia({ video: true })
      .then(() => {
        console.log('Camera access granted.');
      })
      .catch(err => {
        console.error('Camera access denied:', err);
        this.errorMessage = 'Camera access is required to use the scanner.';
      });
  }

  onCamerasFound(devices: MediaDeviceInfo[]): void {
    this.availableDevices = devices;
    if (this.availableDevices.length > 0) {
      this.selectedDevice = this.availableDevices[0]; // Select the first camera by default
    }
  }

  startScanner(): void {
    if (this.selectedDevice) {
      this.scannerEnabled = true;
      this.qrResult = null;
      this.validationStatus = null;
      this.errorMessage = null;
    } else {
      this.errorMessage = 'No camera available or selected.';
    }
  }

  onCodeResult(resultString: string): void {
    this.qrResult = resultString;
    this.scannerEnabled = false; // Stop scanning after a result is found
    this.validateQrCode(resultString);
  }

  validateQrCode(qrCodeId: string): void {
    // Assuming the scanned QR code string is the QR code ID
    this.qrCodeService.validateQrCode(qrCodeId).subscribe({
      next: (isValid: boolean) => {
        this.validationStatus = isValid ? 'VALID' : 'INVALID';
      },
      error: (error: any) => {
        this.validationStatus = 'ERROR';
        this.errorMessage = 'Error validating QR code.';
        console.error('QR code validation error:', error);
      }
    });
  }
}
