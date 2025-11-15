import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivityService, Activity } from './activity.service';

@Component({
  selector: 'app-activities',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './activities.component.html',
  styleUrl: './activities.component.css'
})
export class ActivitiesComponent implements OnInit {
  activities: Activity[] = [];

  constructor(private activityService: ActivityService) { }

  ngOnInit(): void {
    this.activityService.getActivities().subscribe(activities => {
      this.activities = activities;
    });
  }
}