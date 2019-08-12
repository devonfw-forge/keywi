import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {ConfirmationConfig} from '../dialog.service';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent {

  readonly titleKey: string;
  readonly bodyKey: string;

  constructor(
    private readonly dialogRef: MatDialogRef<ConfirmationComponent, boolean>,
    @Inject(MAT_DIALOG_DATA) data: ConfirmationConfig) {

    this.titleKey = data.titleKey;
    this.bodyKey = data.bodyKey ? data.bodyKey : 'general.message.areYouSure';
  }

  onConfirm() {
    this.dialogRef.close(true);
  }
}
