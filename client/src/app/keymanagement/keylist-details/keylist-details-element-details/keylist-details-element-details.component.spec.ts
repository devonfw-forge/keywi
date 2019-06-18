import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistDetailsElementDetailsComponent} from './keylist-details-element-details.component';
import {KeywiMaterialModule} from '../../../general/keywi-material.module';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {FormBuilder, FormsModule, ReactiveFormsModule} from '@angular/forms';

xdescribe('KeylistDetailsElementDetailsComponent', () => {
  let component: KeylistDetailsElementDetailsComponent;
  let fixture: ComponentFixture<KeylistDetailsElementDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [KeylistDetailsElementDetailsComponent],
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
    fixture = TestBed.createComponent(KeylistDetailsElementDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
