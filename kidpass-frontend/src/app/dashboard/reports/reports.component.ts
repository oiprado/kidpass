import { Component, OnInit } from '@angular/core';
import { ReportService } from '../../report.service';
import { Report } from '../../report.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-reports',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './reports.component.html',
  styleUrl: './reports.component.css'
})
export class ReportsComponent implements OnInit {
  reports: Report[] = [];

  constructor(private reportService: ReportService) { }

  ngOnInit(): void {
    this.reportService.getReports().subscribe(reports => {
      this.reports = reports;
    });
  }
}
