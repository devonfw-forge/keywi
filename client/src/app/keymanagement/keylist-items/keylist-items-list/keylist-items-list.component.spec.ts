import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistItemsListComponent} from './keylist-items-list.component';
import {AgGridModule} from 'ag-grid-angular';
import {KeywiMaterialModule} from '../../../general/keywi-material.module';

xdescribe('KeylistItemsListComponent', () => {
  let component: KeylistItemsListComponent;
  let fixture: ComponentFixture<KeylistItemsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [KeylistItemsListComponent],
      imports: [
        AgGridModule.withComponents([KeylistItemsListComponent]),
        KeywiMaterialModule
        // TranslateTestingModule.withTranslations('en', require('../../../general/i18n/translation_en.ts').default)
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KeylistItemsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
