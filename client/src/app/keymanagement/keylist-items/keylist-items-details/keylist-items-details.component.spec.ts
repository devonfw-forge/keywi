import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistItemsDetailsComponent} from './keylist-items-details.component';
import {KeywiMaterialModule} from '../../../general/keywi-material.module';
import {FormBuilder, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TranslateTestingModule} from 'ngx-translate-testing';

describe('KeylistItemsDetailsComponent', () => {
  let component: KeylistItemsDetailsComponent;
  let fixture: ComponentFixture<KeylistItemsDetailsComponent>;
  let element: any;

  beforeEach(async(() => {

    TestBed.configureTestingModule({
      declarations: [KeylistItemsDetailsComponent],
      imports: [
        KeywiMaterialModule,
        TranslateTestingModule.withTranslations({
          ['en']: {}
        }),
        FormsModule,
        ReactiveFormsModule],
      providers: [
        {provide: FormBuilder, useValue: new FormBuilder()}
      ]
    })
      .compileComponents();
    fixture = TestBed.createComponent(KeylistItemsDetailsComponent);
    component = fixture.componentInstance;
    element = fixture.nativeElement;
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
