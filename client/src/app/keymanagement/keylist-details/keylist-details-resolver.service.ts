import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {KeyListEto} from '../common/to/KeyListEto';

@Injectable({
  providedIn: 'root'
})
export class KeylistDetailsResolverService implements Resolve<KeyListEto> {

  constructor(private restService: KeymanagementRestService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<KeyListEto> | KeyListEto {
    const id = +route.paramMap.get('id');
    if (id) {
      return this.restService.findKeyList(id);
    } else {
      return {
        id: 0,
        name: '',
        key: '',
        comment: '',
        disabled: false,
        cacheable: true,
        valueRequired: false,
        ordering: 'NAME',
        permission: ''
      };
    }
  }
}
