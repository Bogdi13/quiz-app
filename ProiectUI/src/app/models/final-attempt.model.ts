export class FinalAttempt {
  id: number;
  idUser: number;
  quizTitle: number;
  score: number;

  constructor(attempt: any = {}) {
    this.id = attempt.id,
    this.idUser = attempt.idUser,
    this.quizTitle = attempt.quizTitle,
    this.score = attempt.score
  }
}