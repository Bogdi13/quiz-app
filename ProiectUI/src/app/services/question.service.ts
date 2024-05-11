import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl = "http://localhost:8080/questionsQuizzes"

  constructor(private http: HttpClient) { }

  loadQuestionsById(quizId: number) : Observable<any> {
    return this.http.get(`${this.baseUrl}/${quizId}`);
  }
}