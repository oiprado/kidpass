export interface Notification {
  id: string;
  userId: string;
  message: string;
  status: 'READ' | 'UNREAD';
  createdAt: string;
}
