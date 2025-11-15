export interface Authorization {
  id: string;
  studentId: string;
  type: 'EVENT' | 'EXIT';
  status: 'PENDING' | 'APPROVED' | 'REJECTED';
  description: string;
}
