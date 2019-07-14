import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistItemsDetailsComponent} from './keylist-items-details.component';
import {KeywiMaterialModule} from '../../../general/keywi-material.module';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {FormBuilder, FormsModule, ReactiveFormsModule} from '@angular/forms';

xdescribe('KeylistItemsDetailsComponent', () => {
  let component: KeylistItemsDetailsComponent;
  let fixture: ComponentFixture<KeylistItemsDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [KeylistItemsDetailsComponent],
      imports: [
        KeywiMaterialModule,
        NoopAnimationsModule,
        // TranslateTestingModule.withTranslations('en', require('../../../general/i18n/translation_en.ts').default),
        FormsModule,
        ReactiveFormsModule],
      providers: [{provide: FormBuilder, useValue: new FormBuilder()}]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KeylistItemsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
