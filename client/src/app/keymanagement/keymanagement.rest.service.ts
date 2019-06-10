import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../general/environment';
import {KeyListEto} from './common/to/KeyListEto';
import {KeyItemEto} from './common/to/KeyItemEto';

@Injectable()
export class KeymanagementRestService {

  constructor(private http: HttpClient) {
  }

  findAllKeylists(): Observable<KeyListEto[]> {
    return this.http.get<KeyListEto[]>(environment.REST_BASE_PATH + '/keylists');
  }

  findKeyList(id: number): Observable<KeyListEto> {
    return this.http.get<KeyListEto>(environment.REST_BASE_PATH + `/keylist/${id}`);
  }

  findKeyItemsForKeyList(id: number): Observable<KeyItemEto[]> {
    return this.http.get<KeyItemEto[]>(environment.REST_BASE_PATH + `/keyitem-for-list/${id}`);
  }
}
