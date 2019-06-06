import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistDetailsComponent} from './keylist-details.component';

describe('KeylistDetailsComponent', () => {
  let component: KeylistDetailsComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [ KeylistDetailsComponent ]
    });
  }));

  beforeEach(() => {
    component = TestBed.get(KeylistDetailsComponent);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
