import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {AuthenticationGuard} from './authentication/authentication-guard.service';
import {AuthenticationService} from './authentication/authentication.service';
import {LoginBasicService} from './authentication/login-basic.service';
import {LoginComponent} from './login/login.component';
import {LoginService} from './authentication/login.service';
import {ConfirmationComponent} from './dialog/confirmation/confirmation.component';
import {KeywiMaterialModule} from './keywi-material.module';
import {TranslateModule} from '@ngx-translate/core';

@NgModule({
  declarations: [
    LoginComponent,
    ConfirmationComponent
  ],
  imports: [
    FormsModule,
    KeywiMaterialModule,
    TranslateModule
  ],
  providers: [
    AuthenticationService,
    AuthenticationGuard,
    {
      provide: LoginService, useClass: LoginBasicService}
    ],
  entryComponents: [
    ConfirmationComponent
  ]
})
export class GeneralModule {
}
