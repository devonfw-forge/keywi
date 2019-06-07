import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KeylistDetailsElementListComponent } from './keylist-details-element-list.component';

describe('KeylistDetailsElementListComponent', () => {
  let component: KeylistDetailsElementListComponent;
  let fixture: ComponentFixture<KeylistDetailsElementListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KeylistDetailsElementListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KeylistDetailsElementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
