import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../authorization.service';
import { Authorization } from '../../authorization.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-authorizations',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './authorizations.component.html',
  styleUrl: './authorizations.component.css'
})
export class AuthorizationsComponent implements OnInit {
  authorizations: Authorization[] = [];

  constructor(private authorizationService: AuthorizationService) { }

  ngOnInit(): void {
    this.authorizationService.getAuthorizations().subscribe(authorizations => {
      this.authorizations = authorizations;
    });
  }
}
