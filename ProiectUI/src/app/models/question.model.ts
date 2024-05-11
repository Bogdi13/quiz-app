export class Question {
  id: number;
  text: string;
  choiceA: string;
  choiceB: string;
  choiceC: string;
  correctChoice: string;
  selectedChoice: string;

  constructor(question: any = {}){
    this.id = question.id,
    this.text = question.firstName,
    this.choiceA = question.lastName,
    this.choiceB = question.username,
    this.choiceC = question.password,
    this.correctChoice = question.correctChoice,
    this.selectedChoice =  question.selectedChoice || ''
  }
}