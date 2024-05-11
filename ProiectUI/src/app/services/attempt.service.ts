import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Attempt } from '../models/attempt.model';

@Injectable({
  providedIn: 'root',
})
export class AttemptService {
  private baseUrl = 'http://localhost:8080/attempts';

  constructor(private http: HttpClient) {}

  createAttempt(data: Attempt): Observable<any> {
    return this.http.post(`${this.baseUrl}/`, data);
  }

  loadAttemptsByUserId(idUser: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${idUser}`);
  }
}
