import {Injectable} from '@angular/core';

@Injectable()
export class AuthenticationService {
  private logged = false;
  private token: string;

  public isLogged(): boolean {
    return this.logged || false;
  }

  public setLogged(logged: boolean): void {
    this.logged = logged;
  }

  public getToken(): string {
    return this.token;
  }

  public setToken(token: string): void {
    this.token = token;
  }
}
