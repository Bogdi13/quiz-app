import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../services/auth.service';

import { AuthModel } from '../models/auth.model';
import { DialogService } from '../services/dialog.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss'],
})
export class AuthComponent implements OnInit {
  authForm!: FormGroup;

  constructor(
    private authService: AuthService,
    private router: Router,
    private toastrService: ToastrService,
    private dialogService: DialogService
  ) {}

  ngOnInit(): void {
    this.authForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  onLogin() {
    if (this.authForm.valid) {
      const username = this.authForm.controls.username.value;
      const password = this.authForm.controls.password.value;
      this.authService
        .loadUserByUsername(new AuthModel({username, password}))
        .subscribe({
          next: (result) => {
            if (result.username) {
              localStorage.setItem('idUser', JSON.stringify(result.id));
              this.router.navigate(['/home']);
            }
          },
          error: (error) => {
            if (error.status === 404) {
              const title = "Eroare autentificare";
              const message = "Credențiale incorecte. Vă rugăm să verificați informațiile de autentificare."
              this.dialogService.openDialog(title, message);
            } else {
              const title = "Eroare autentificare";
              const message = "A apărut o eroare în timpul autentificării. Vă rugăm să încercați din nou mai târziu."
              this.dialogService.openDialog(title, message);
            }
          },
        });
    }
  }

  getErrorMessage() {
    if (this.authForm.controls.username.hasError('required')) {
      return 'You must enter a value';
    }
    return this.authForm.controls.username.hasError('username')
      ? 'Not a valid username'
      : '';
  }
}
