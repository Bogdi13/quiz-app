export class Attempt {
  id: number;
  idUser: number;
  idQuiz: number;
  score: number;

  constructor(attempt: any = {}) {
    this.id = attempt.id,
    this.idUser = attempt.idUser,
    this.idQuiz = attempt.idQuiz,
    this.score = attempt.score
  }
}
