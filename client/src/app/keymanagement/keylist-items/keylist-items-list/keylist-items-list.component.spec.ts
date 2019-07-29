import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistItemsListComponent} from './keylist-items-list.component';
import {AgGridModule} from 'ag-grid-angular';
import {KeywiMaterialModule} from '../../../general/keywi-material.module';
import {TranslateTestingModule} from 'ngx-translate-testing';

describe('KeylistItemsListComponent', () => {
  let component: KeylistItemsListComponent;
  let fixture: ComponentFixture<KeylistItemsListComponent>;
  let element: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [KeylistItemsListComponent],
      imports: [
        AgGridModule.withComponents([KeylistItemsListComponent]),
        KeywiMaterialModule,
        TranslateTestingModule.withTranslations({
          ['en']: {}
        })]
    })
      .compileComponents();
    fixture = TestBed.createComponent(KeylistItemsListComponent);
    component = fixture.componentInstance;
    element = fixture.nativeElement;
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
