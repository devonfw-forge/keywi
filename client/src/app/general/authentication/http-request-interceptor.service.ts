import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {AuthenticationService} from './authentication.service';


/**
 * Interceptor for http requests. Responsible for adding additional headers (csrf token) and error handling
 */
@Injectable()
export class HttpRequestInterceptorService implements HttpInterceptor {
  constructor(private router: Router,
              private authenticationService: AuthenticationService) {
  }

  intercept(request: HttpRequest<any>, httpHandler: HttpHandler): Observable<any> {

    const csrfToken: string = this.authenticationService ? this.authenticationService.getToken() : undefined;
    let changedRequest: Observable<HttpEvent<any>>;
    if (csrfToken) {
      const authReq: HttpRequest<any> = request.clone({
        withCredentials: true,
        setHeaders: {'x-csrf-token': csrfToken}
      });
      changedRequest = httpHandler.handle(authReq);
    } else {
      changedRequest = httpHandler.handle(request);
    }
    return changedRequest.pipe(
      catchError(error => throwError(error.error.message))
    );
  }
}
