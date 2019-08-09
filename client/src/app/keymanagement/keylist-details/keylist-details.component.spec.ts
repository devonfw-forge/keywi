import {async} from '@angular/core/testing';

import {KeylistDetailsComponent} from './keylist-details.component';
import {FormBuilder} from '@angular/forms';
import {of, Subject} from 'rxjs';
import {KeyListEto} from '../common/to/KeyListEto';
import {KEYLIST_OVERVIEW} from '../keymanagement-routing.module';

describe('KeylistDetailsComponent', () => {
  let component: KeylistDetailsComponent;
  let fakeService: any;
  let fakeActivatedRoute: any;
  let fakeRouter: any;
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

    component = new KeylistDetailsComponent(fakeService, fakeActivatedRoute, fakeRouter, new FormBuilder());
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
});
