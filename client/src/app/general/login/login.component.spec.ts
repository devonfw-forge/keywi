import {async, TestBed} from '@angular/core/testing';
import {Router} from '@angular/router';
import {AuthenticationService} from '../authentication/authentication.service';
import {LoginBasicService} from '../authentication/login-basic.service';
import {LoginService} from '../authentication/login.service';

import {LoginComponent} from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let loginServiceMock: LoginBasicService;
  let router: Router;
  let authenticationService: AuthenticationService;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [LoginComponent, [
        {provide: LoginService, useValue: loginServiceMock},
        {provide: Router, useValue: router},
        {provide: AuthenticationService, useValue: authenticationService}]
      ]
    });
  }));

  beforeEach(() => {
    component = TestBed.get(LoginComponent);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
