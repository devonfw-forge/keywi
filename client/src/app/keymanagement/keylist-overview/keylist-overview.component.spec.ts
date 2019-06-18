import {async, TestBed} from '@angular/core/testing';
import {Router} from '@angular/router';
import {KeymanagementRestService} from '../keymanagement.rest.service';

import {KeylistOverviewComponent} from './keylist-overview.component';

describe('KeylistOverviewComponent', () => {
  let component: KeylistOverviewComponent;
  const keyManagementRestService: KeymanagementRestService = undefined;
  const router: Router = undefined;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [KeylistOverviewComponent,
        {provide: KeymanagementRestService, useValue: keyManagementRestService},
        {provide: Router, useValue: router}]
    });
  }));

  beforeEach(() => {
    component = TestBed.get(KeylistOverviewComponent);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
