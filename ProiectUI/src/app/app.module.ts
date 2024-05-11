import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { HeaderComponent } from './header/header.component';
import { CommonModule } from '@angular/common';
import { AuthComponent } from './auth/auth.component';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ToastrModule } from 'ngx-toastr';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { StoreModule } from '@ngrx/store';
import { QuizComponent } from './quiz/quiz.component';
import { QuestionsComponent } from './questions/questions.component';
import { MatRadioModule } from '@angular/material/radio';
import { MatDialogModule } from '@angular/material/dialog';
import { DialogContentComponent } from './dialog-content.component';
import { AttemptsComponent } from './attempts/attempts.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AuthComponent,
    HomeComponent,
    QuizComponent,
    QuestionsComponent,
    DialogContentComponent,
    AttemptsComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatCardModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    MatRadioModule,
    MatDialogModule,
    StoreModule.forRoot({}, {}),
  ],
  exports: [MatFormFieldModule, MatToolbarModule, MatCardModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
