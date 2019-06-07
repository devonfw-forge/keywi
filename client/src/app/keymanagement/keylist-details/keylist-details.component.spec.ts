import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {KeylistDetailsComponent} from './keylist-details.component';
import {RouterTestingModule} from '@angular/router/testing';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {Observable, of} from 'rxjs';
import {KeyListEto} from '../common/to/KeyListEto';
import {KeylistDetailsElementDetailsComponent} from './keylist-details-element-details/keylist-details-element-details.component';
import {KeylistDetailsElementListComponent} from './keylist-details-element-list/keylist-details-element-list.component';
import {KeywiMaterialModule} from '../../general/keywi-material.module';
import {AgGridModule} from 'ag-grid-angular';
import {KeylistOverviewComponent} from '../keylist-overview/keylist-overview.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';

class KeymanagementRestServiceMock {
  findAllKeylists(): Observable<KeyListEto[]> {
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

describe('KeylistDetailsComponent', () => {
  let component: KeylistDetailsComponent;
  let fixture: ComponentFixture<KeylistDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [KeylistDetailsComponent, KeylistDetailsElementDetailsComponent, KeylistDetailsElementListComponent],
      imports: [
        RouterTestingModule.withRoutes([]),
        KeywiMaterialModule,
        NoopAnimationsModule,
        AgGridModule.withComponents([KeylistDetailsElementListComponent])
      ],
      providers: [{provide: KeymanagementRestService, useClass: KeymanagementRestServiceMock}]
    });
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KeylistDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
