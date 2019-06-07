import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KeylistDetailsElementDetailsComponent } from './keylist-details-element-details.component';

describe('KeylistDetailsElementDetailsComponent', () => {
  let component: KeylistDetailsElementDetailsComponent;
  let fixture: ComponentFixture<KeylistDetailsElementDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KeylistDetailsElementDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KeylistDetailsElementDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
