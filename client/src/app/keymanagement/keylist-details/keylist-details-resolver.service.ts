import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot} from '@angular/router';
import {KeyListEto} from '../common/to/KeyListEto';
import {EMPTY, Observable, of} from 'rxjs';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {mergeMap, take} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class KeylistDetailsResolverService implements Resolve<KeyListEto> {

  constructor(private restService: KeymanagementRestService, private router: Router) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<KeyListEto> | Observable<never> {
    const id = +route.paramMap.get('id');
    return this.restService.findKeyList(id).pipe(
      take(1),
      mergeMap(keylist => {
          if (keylist) {
            return of(keylist);
          } else {
            // not found
            this.router.navigate(['/']);
            return EMPTY;
          }
        }
      )
    );
  }
}
