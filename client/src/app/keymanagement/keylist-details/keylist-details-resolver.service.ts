import {ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot} from '@angular/router';
import {KeyListCto} from '../common/to/KeyListCto';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {KeyListEto} from '../common/to/KeyListEto';

@Injectable({
  providedIn: 'root'
})
export class KeylistDetailsResolverService implements Resolve<KeyListEto> {

  constructor(private restService: KeymanagementRestService, private router: Router) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<KeyListEto> | KeyListEto {
    const id = +route.paramMap.get('id');
    return this.restService.findKeyList(id);
  }
}
