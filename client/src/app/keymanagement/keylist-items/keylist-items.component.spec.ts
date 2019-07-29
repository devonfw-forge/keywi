import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistItemsComponent} from './keylist-items.component';
import {RouterTestingModule} from '@angular/router/testing';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {KeylistItemsDetailsComponent} from './keylist-items-details/keylist-items-details.component';
import {KeylistItemsListComponent} from './keylist-items-list/keylist-items-list.component';
import {KeywiMaterialModule} from '../../general/keywi-material.module';
import {AgGridModule} from 'ag-grid-angular';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {ActivatedRoute} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TranslateTestingModule} from 'ngx-translate-testing';

describe('KeylistItemsComponent', () => {
  let component: KeylistItemsComponent;
  let fixture: ComponentFixture<KeylistItemsComponent>;
  let element: any;
  let fakeRest: any;
  let fakeActivatedRoute: any;

  beforeEach(async(() => {
    fakeRest = {};
    fakeActivatedRoute = {};

    TestBed.configureTestingModule({
      declarations: [
        KeylistItemsComponent,
        KeylistItemsDetailsComponent,
        KeylistItemsListComponent
      ],
      imports: [
        RouterTestingModule.withRoutes([]),
        KeywiMaterialModule,
        NoopAnimationsModule,
        TranslateTestingModule.withTranslations({
          ['en']: {}
        }),
        FormsModule,
        ReactiveFormsModule,
        AgGridModule.withComponents([KeylistItemsListComponent])
      ],
      providers: [
        {provide: KeymanagementRestService, useValue: fakeRest},
        {provide: ActivatedRoute, useValue: fakeActivatedRoute}
      ]
    });

    fixture = TestBed.createComponent(KeylistItemsComponent);
    component = fixture.componentInstance;
    element = fixture.nativeElement;
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
