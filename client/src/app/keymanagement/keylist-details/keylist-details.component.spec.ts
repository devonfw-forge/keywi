import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistDetailsComponent} from './keylist-details.component';
import {KeywiMaterialModule} from '../../general/keywi-material.module';
import {TranslateTestingModule} from 'ngx-translate-testing';
import {FormBuilder, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {ActivatedRoute, Router} from '@angular/router';

describe('KeylistDetailsComponent', () => {
  let component: KeylistDetailsComponent;
  let fixture: ComponentFixture<KeylistDetailsComponent>;
  let element: any;
  let fakeService: any;
  let fakeActivatedRoute: any;
  let fakeRouter: any;

  beforeEach(async(() => {
    fakeService = {};
    fakeActivatedRoute = {};
    fakeRouter = {};

    TestBed.configureTestingModule({
      declarations: [
        KeylistDetailsComponent
      ],
      imports: [
        KeywiMaterialModule,
        TranslateTestingModule.withTranslations({
          ['en']: {}
        }),
        FormsModule,
        ReactiveFormsModule
      ],
      providers: [
        {provide: FormBuilder, useValue: new FormBuilder()},
        {provide: KeymanagementRestService, useValue: fakeService},
        {provide: ActivatedRoute, useValue: fakeActivatedRoute},
        {provide: Router, useValue: fakeRouter}
      ]
    })
      .compileComponents();
    fixture = TestBed.createComponent(KeylistDetailsComponent);
    component = fixture.componentInstance;
    element = fixture.nativeElement;
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
