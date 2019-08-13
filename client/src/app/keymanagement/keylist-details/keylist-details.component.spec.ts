import {async} from '@angular/core/testing';

import {KeylistDetailsComponent} from './keylist-details.component';
import {FormBuilder} from '@angular/forms';
import {of, Subject, throwError} from 'rxjs';
import {KeyListEto} from '../common/to/KeyListEto';
import {KEYLIST_OVERVIEW} from '../keymanagement-routing.module';
import {error} from 'util';

describe('KeylistDetailsComponent', () => {
  let component: KeylistDetailsComponent;
  let fakeService: any;
  let fakeActivatedRoute: any;
  let fakeRouter: any;
  let fakeToastr: any;
  let data$: Subject<{ keyList: KeyListEto }>;
  let keyList: KeyListEto;

  beforeEach(async(() => {
    keyList = {
      id: 10,
      key: 'foo',
      name: 'Foo',
      comment: 'Foo key list',
      ordering: 'NAME',
      valueRequired: true,
      cacheable: true,
      disabled: false,
      permission: ''
    };
    data$ = new Subject<{ keyList: KeyListEto }>();
    fakeService = {
      saveKeyList: () => {
      }
    };
    fakeActivatedRoute = {data: data$};
    fakeRouter = {
      navigate: () => {
      }
    };
    fakeToastr = {
      error: () => {
      }
    };

    component = new KeylistDetailsComponent(fakeService, fakeActivatedRoute, fakeRouter, fakeToastr, new FormBuilder());
    component.ngOnInit();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should save key list details and go to overview', () => {
    // given
    spyOn(fakeService, 'saveKeyList').and.returnValue(of({...keyList}));
    spyOn(fakeRouter, 'navigate');
    // when
    data$.next({keyList: {...keyList}});
    component.onSave();
    // then
    expect(fakeService.saveKeyList).toHaveBeenCalledWith({...keyList});
    expect(fakeRouter.navigate).toHaveBeenCalledWith([KEYLIST_OVERVIEW]);
  });

  it('should show error message in case on backend error', () => {
    // given
    const errMessage = 'Error!';
    spyOn(fakeService, 'saveKeyList').and.returnValue(throwError(errMessage));
    spyOn(fakeRouter, 'navigate');
    spyOn(fakeToastr, 'error');
    // when
    data$.next({keyList: {...keyList}});
    component.onSave();
    // then
    expect(fakeService.saveKeyList).toHaveBeenCalledWith({...keyList});
    expect(fakeRouter.navigate).not.toHaveBeenCalled();
    expect(fakeToastr.error).toHaveBeenCalledWith(errMessage);
  });

});
