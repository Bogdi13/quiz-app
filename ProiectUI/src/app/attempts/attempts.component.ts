import { Component, OnInit } from '@angular/core';
import { AttemptService } from '../services/attempt.service';
import { FinalAttempt } from '../models/final-attempt.model';

@Component({
  selector: 'app-attempts',
  templateUrl: './attempts.component.html',
  styleUrls: ['./attempts.component.scss'],
})
export class AttemptsComponent implements OnInit {
  attempts!: Array<FinalAttempt>;

  constructor(private attemptService: AttemptService) {}

  ngOnInit(): void {
    this.loadAttemptsByUserId();
  }

  loadAttemptsByUserId() {
    const idUserString = localStorage.getItem('idUser');
    const idUser = idUserString ? parseInt(idUserString, 10) : 0;
    this.attemptService.loadAttemptsByUserId(idUser).subscribe((attempts) => {
      this.attempts = attempts;
    });
  }
}
