import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistItemsComponent} from './keylist-items.component';
import {RouterTestingModule} from '@angular/router/testing';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {Observable, of} from 'rxjs';
import {KeyListEto} from '../common/to/KeyListEto';
import {KeylistItemsDetailsComponent} from './keylist-items-details/keylist-items-details.component';
import {KeylistItemsListComponent} from './keylist-items-list/keylist-items-list.component';
import {KeywiMaterialModule} from '../../general/keywi-material.module';
import {AgGridModule} from 'ag-grid-angular';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {KeyItemEto} from '../common/to/KeyItemEto';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

class KeymanagementRestServiceMock {
  findAllKeylists(): Observable<KeyListEto[]> {
    return of([]);
  }

  findKeyItemsForKeyList(id: number): Observable<KeyItemEto[]> {
    return of([]);
  }

  findKeyList(id: number): Observable<KeyListEto> {
    return of({
      name: '',
      key: '',
      ordering: {
        columnName: '',
        propertyName: ''
      },
      valueRequired: false,
      permission: '',
      cacheable: false,
      disabled: false,
      comment: '',
      id: 1,
      modificationCounter: 1,
      revision: 1,
      modificationDate: 1
    });
  }
}

class ParamMapMock implements ParamMap {
  readonly keys = ['id'];

  get(name: string): string | null {
    return '1';
  }

  getAll(name: string): string[] {
    return ['1'];
  }

  has(name: string): boolean {
    return true;
  }
}

xdescribe('KeylistItemsComponent', () => {
  let component: KeylistItemsComponent;
  let fixture: ComponentFixture<KeylistItemsComponent>;

  beforeEach(async(() => {
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
        // TranslateTestingModule.withTranslations('en', require('../../general/i18n/translation_en.ts').default),
        FormsModule,
        ReactiveFormsModule,
        AgGridModule.withComponents([KeylistItemsListComponent])
      ],
      providers: [
        {provide: KeymanagementRestService, useClass: KeymanagementRestServiceMock},
        {
          provide: ActivatedRoute, useValue: {
            data: of({keyList: {name: 'foo'}}),
            paramMap: of(new ParamMapMock())
          }
        }
      ]
    });
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KeylistItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
