import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {KEYLIST_OVERVIEW} from '../../keymanagement/keymanagement-routing.module';
import {AuthenticationService} from '../authentication/authentication.service';
import {LoginService} from '../authentication/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService,
              private router: Router,
              private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
  }

  login(login) {
    this.loginService.login(login.value.username, login.value.password)
      .subscribe(() => {
        this.getCsrfToken();
      });
  }

  private getCsrfToken() {
    this.loginService.getCsrf()
      .subscribe((data: any) => {
        this.authenticationService.setToken(data.token);
        this.authenticationService.setLogged(true);
        this.router.navigateByUrl(KEYLIST_OVERVIEW);
      });
  }
}
