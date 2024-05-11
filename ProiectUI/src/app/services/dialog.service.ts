import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogContentComponent } from '../dialog-content.component';

@Injectable({
  providedIn: 'root',
})
export class DialogService {
  constructor(private dialog: MatDialog) {}

  openDialog(title: string, message: string): void {
    this.dialog.open(DialogContentComponent, {
      data: { title, message },
    });
  }
}
