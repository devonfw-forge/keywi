import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {AuthenticationGuard} from './authentication/authentication-guard.service';
import {AuthenticationService} from './authentication/authentication.service';
import {LoginBasicService} from './authentication/login-basic.service';
import {LoginComponent} from './login/login.component';
import {LoginService} from './authentication/login.service';

@NgModule({
  declarations: [LoginComponent],
  imports: [FormsModule],
  providers: [
    AuthenticationService,
    AuthenticationGuard,
    {
      provide: LoginService, useClass: LoginBasicService}
    ]
})
export class GeneralModule {
}
