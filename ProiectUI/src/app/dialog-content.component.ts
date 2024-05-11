import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-content',
  template: `
    <h2>{{ data.title }}</h2>
    <p>{{ data.message }}</p>
  `,
})
export class DialogContentComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}
}
