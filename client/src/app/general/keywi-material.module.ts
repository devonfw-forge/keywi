import {NgModule} from '@angular/core';
import {MatButtonModule, MatInputModule, MatRadioModule} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/typings/esm5/form-field';
import {FlexLayoutModule} from '@angular/flex-layout';

@NgModule({
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    FlexLayoutModule
  ],
  exports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    FlexLayoutModule
  ]
})
export class KeywiMaterialModule {
}
