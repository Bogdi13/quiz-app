import { Component, OnInit } from '@angular/core';
import { QuizService } from '../services/quiz.service';
import { Router } from '@angular/router';
import { Quiz } from '../models/quiz.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  quizes!: Array<Quiz>;

  constructor(
    private quizService: QuizService,
    private router: Router,
    ) { }

  ngOnInit(): void {
    this.loadQuizes();
  }

  loadQuizes() {
    this.quizService.loadQuizes().subscribe((quizes) => {
        this.quizes = quizes;
      }
    );
  }

  onSolveQuiz(quiz: Quiz) {
    this.router.navigate(['/quiz', quiz.id]);
  }

  onViewAllAttempts() {
    this.router.navigate(['/attempts']);
  }

}
