import {Observable} from 'rxjs';

export abstract class LoginService {
    abstract login(username: string, password: string): Observable<any>;

    abstract getCsrf(): Observable<any>;
}
