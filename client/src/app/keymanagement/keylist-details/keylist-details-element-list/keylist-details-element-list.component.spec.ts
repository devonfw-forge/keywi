import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistDetailsElementListComponent} from './keylist-details-element-list.component';
import {AgGridModule} from 'ag-grid-angular';
import {KeywiMaterialModule} from '../../../general/keywi-material.module';

describe('KeylistDetailsElementListComponent', () => {
  let component: KeylistDetailsElementListComponent;
  let fixture: ComponentFixture<KeylistDetailsElementListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [KeylistDetailsElementListComponent],
      imports: [
        AgGridModule.withComponents([KeylistDetailsElementListComponent]),
        KeywiMaterialModule
      ]
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
