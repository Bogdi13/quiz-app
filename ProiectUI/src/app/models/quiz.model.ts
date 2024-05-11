export class Quiz {
  id: number;
  title: string;

  constructor(quiz: any = {}) {
    (this.id = quiz.id), (this.title = quiz.title);
  }
}
