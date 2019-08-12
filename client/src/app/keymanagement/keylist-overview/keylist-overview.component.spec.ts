import {async, TestBed} from '@angular/core/testing';
import {Router} from '@angular/router';
import {KeymanagementRestService} from '../keymanagement.rest.service';

import {KeylistOverviewComponent} from './keylist-overview.component';
import {DialogService} from '../../general/dialog/dialog.service';

describe('KeylistOverviewComponent', () => {
  let component: KeylistOverviewComponent;
  const keyManagementRestService: KeymanagementRestService = undefined;
  const router: Router = undefined;
  let fakeDialogService: any;

  beforeEach(async(() => {
    fakeDialogService = {};
    TestBed.configureTestingModule({
      providers: [KeylistOverviewComponent,
        {provide: KeymanagementRestService, useValue: keyManagementRestService},
        {provide: Router, useValue: router},
        {provide: DialogService, useValue: fakeDialogService}]
    });
  }));

  beforeEach(() => {
    component = TestBed.get(KeylistOverviewComponent);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
