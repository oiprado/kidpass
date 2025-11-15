export interface QrCode {
  id: string;
  authorizationId: string;
  qrCodeImage: string; // Base64 encoded image
  expiresAt: string;
}
