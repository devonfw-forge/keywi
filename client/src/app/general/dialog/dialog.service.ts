import {Injectable} from '@angular/core';
import {MatDialog, MatDialogConfig} from '@angular/material';
import {Observable} from 'rxjs';
import {ConfirmationComponent} from './confirmation/confirmation.component';

export interface ConfirmationConfig {
  titleKey: string;
  bodyKey?: string;
}

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private readonly dialog: MatDialog) {
  }

  public openDialog<T, R>(component: any, width: string | number, height: string | number, data: T): Observable<R | undefined> {
    const toPixels = (amount: number) => '' + amount + 'px';
    const determine = (amount: number | string) => typeof amount === 'number' ? toPixels(amount) : amount;

    const config = new MatDialogConfig();
    config.width = determine(width);
    config.height = determine(height);
    config.data = data;

    return this.dialog.open(component, config).afterClosed();
  }

  public openConfirmationDialog(confirmationConfig: ConfirmationConfig): Observable<boolean | undefined> {
    return this.openDialog(ConfirmationComponent, 400, 200, confirmationConfig);
  }
}
