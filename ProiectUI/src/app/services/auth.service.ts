import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { AuthModel } from '../models/auth.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}

  loadUserByUsername(data: AuthModel): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, data);
  }
}
