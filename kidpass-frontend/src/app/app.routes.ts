import { Routes } from '@angular/router';
import { authRoutes } from './auth/auth.routes';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './dashboard/profile/profile.component';
import { ActivitiesComponent } from './dashboard/activities/activities.component';
import { BookingsComponent } from './dashboard/bookings/bookings.component';
import { NotificationsComponent } from './dashboard/notifications/notifications.component';
import { StudentsComponent } from './dashboard/students/students.component';
import { AuthorizationsComponent } from './dashboard/authorizations/authorizations.component';
import { QrCodeComponent } from './dashboard/qrcode/qrcode.component';
import { ReportsComponent } from './dashboard/reports/reports.component';
import { ScannerComponent } from './scanner/scanner.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  ...authRoutes,
  {
    path: 'dashboard',
    component: DashboardComponent,
    children: [
      { path: '', redirectTo: 'profile', pathMatch: 'full' },
      { path: 'profile', component: ProfileComponent },
      { path: 'activities', component: ActivitiesComponent },
      { path: 'bookings', component: BookingsComponent },
      { path: 'notifications', component: NotificationsComponent },
      { path: 'students', component: StudentsComponent },
      { path: 'authorizations', component: AuthorizationsComponent },
      { path: 'qrcode', component: QrCodeComponent },
      { path: 'reports', component: ReportsComponent },
    ],
  },
  { path: 'scanner', component: ScannerComponent },
  { path: '**', redirectTo: 'login' },
];
