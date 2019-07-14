import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KeylistDetailsComponent } from './keylist-details.component';

describe('KeylistDetailsComponent', () => {
  let component: KeylistDetailsComponent;
  let fixture: ComponentFixture<KeylistDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KeylistDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KeylistDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
