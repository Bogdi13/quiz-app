import { Component,  OnInit } from '@angular/core';
import { ActivatedRoute, } from '@angular/router';
import { QuestionService } from '../services/question.service';
import { Question } from '../models/question.model';
import { MatRadioChange } from '@angular/material/radio';
import { Attempt } from '../models/attempt.model';
import { DialogService } from '../services/dialog.service';
import { AttemptService } from '../services/attempt.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss'],
})
export class QuizComponent implements OnInit {
  quizId!: number;
  questions!: Array<Question>;
  score: number = 0;

  constructor(
    private questionService: QuestionService,
    private attemptService: AttemptService,
    private route: ActivatedRoute,
    private dialogService: DialogService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.quizId = params['id'];
      this.loadQuestionsByQuizId();
    });
  }

  loadQuestionsByQuizId() {
    this.questionService.loadQuestionsById(this.quizId).subscribe((questions) => {
      this.questions = questions;
    });
  }

  onRadioChange(event: MatRadioChange, index: number) {
    const selectedValue = event.value;
    this.questions[index].selectedChoice = event.value;
    console.log(this.questions);
    console.log('Selected Value:', selectedValue, "index ", index);
  }

  onSubmit() {
    this.questions.forEach((question) => {
      if(question.selectedChoice === question.correctChoice){
        this.score++;
      }
    });
    const idUser = localStorage.getItem('idUser');
    const attempt = new Attempt({ id: 0, idUser: idUser , idQuiz: this.quizId, score: this.score})
    const maxScore = this.questions.length;
    const title = "Final Quiz";
    const message = "Ai raspuns corect la " + this.score.toString() + " intrebari din " + maxScore.toString() + " intrebari.";
    this.dialogService.openDialog(title, message);
    this.attemptService.createAttempt(attempt);
  }
}
