import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot} from '@angular/router';
import {EMPTY, Observable, of, zip} from 'rxjs';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {mergeMap, take} from 'rxjs/operators';
import {KeyListCto} from '../common/to/KeyListCto';

@Injectable({
  providedIn: 'root'
})
export class KeylistDetailsResolverService implements Resolve<KeyListCto> {

  constructor(private restService: KeymanagementRestService, private router: Router) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<KeyListCto> | Observable<never> {
    const id = +route.paramMap.get('id');

    return zip(
      this.restService.findKeyList(id),
      this.restService.findKeyItemsForKeyList(id))
      .pipe(
        take(1),
        mergeMap(array => {
          if (array[0]) {
            return of({
              keyList: array[0],
              keyItems: array[1]
            });
          } else { // not found
            this.router.navigate(['/']);
            return EMPTY;
          }
        })
      );
  }
}
