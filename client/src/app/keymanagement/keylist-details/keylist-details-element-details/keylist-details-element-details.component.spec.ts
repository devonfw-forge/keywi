import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistDetailsElementDetailsComponent} from './keylist-details-element-details.component';
import {KeywiMaterialModule} from '../../../general/keywi-material.module';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';

describe('KeylistDetailsElementDetailsComponent', () => {
  let component: KeylistDetailsElementDetailsComponent;
  let fixture: ComponentFixture<KeylistDetailsElementDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [KeylistDetailsElementDetailsComponent],
      imports: [KeywiMaterialModule, NoopAnimationsModule]
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
