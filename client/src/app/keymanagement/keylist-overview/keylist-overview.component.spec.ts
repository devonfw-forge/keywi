import {async, TestBed} from '@angular/core/testing';
import {KeymanagementRestService} from '../keymanagement.rest.service';

import {KeylistOverviewComponent} from './keylist-overview.component';

describe('KeylistOverviewComponent', () => {
  let component: KeylistOverviewComponent;
  const keyManagementRestService: KeymanagementRestService = undefined;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [ KeylistOverviewComponent,
        {provide: KeymanagementRestService, useValue: keyManagementRestService}]
    });
  }));

  beforeEach(() => {
    component = TestBed.get(KeylistOverviewComponent);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
