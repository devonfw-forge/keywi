import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../environment';
import {LoginService} from './login.service';


@Injectable()
export class LoginBasicService extends LoginService {
  constructor(private http: HttpClient) {
    super();
  }

  login(username: string, password: string): Observable<any> {
    return this.http.post(environment.LOGIN_PATH,
      {
        j_username: username,
        j_password: password
      },
      {
        withCredentials: true,
        responseType: 'text'
      }
    );
  }

  getCsrf(): Observable<any> {
    return this.http.get(environment.CSRF_PATH, {withCredentials: true});
  }
}
