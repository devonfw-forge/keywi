import {HttpClient, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../general/environment';
import {KeyListEto} from './common/to/KeyListEto';
import {KeyItemEto} from './common/to/KeyItemEto';

@Injectable({
  providedIn: 'root'
})
export class KeymanagementRestService {

  constructor(private readonly http: HttpClient) {
  }

  findAllKeylists(): Observable<KeyListEto[]> {
    return this.http.get<KeyListEto[]>(environment.REST_BASE_PATH + '/keylists');
  }

  findKeyList(id: number): Observable<KeyListEto> {
    return this.http.get<KeyListEto>(environment.REST_BASE_PATH + `/keylist/${id}`);
  }

  deleteKeyList(id: number): Observable<HttpResponse<Object>> {
    return this.http.delete(environment.REST_BASE_PATH + `/keylist/${id}`, {observe: 'response'});
  }

  findKeyItemsForKeyList(id: number): Observable<KeyItemEto[]> {
    return this.http.get<KeyItemEto[]>(environment.REST_BASE_PATH + `/keyitem-for-list/${id}`);
  }

  saveKeyList(keylist: KeyListEto): Observable<KeyListEto> {
    return this.http.post<KeyListEto>(environment.REST_BASE_PATH + `/keylist`, keylist);
  }

  saveKeyItem(item: KeyItemEto): Observable<KeyItemEto> {
    return this.http.post<KeyItemEto>(environment.REST_BASE_PATH + `/keyitem`, item);
  }

  deleteKeyItem(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<HttpResponse<any>>(environment.REST_BASE_PATH + `/keyitem/${id}`, {observe: 'response'});
  }
}
