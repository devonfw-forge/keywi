import {Component, EventEmitter, Input, OnDestroy, OnInit, Output, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {KeyItemEto} from '../../common/to/KeyItemEto';
import {TranslateService} from '@ngx-translate/core';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';

@Component({
  selector: 'app-keylist-details-element-list',
  templateUrl: './keylist-items-list.component.html',
  styleUrls: ['./keylist-items-list.component.css']
})
export class KeylistItemsListComponent implements OnInit, OnDestroy {

  @Input()
  values: KeyItemEto[];

  @Output()
  rowSelected = new EventEmitter<KeyItemEto | undefined>();

  @ViewChild(AgGridAngular, {static: false})
  agGrid: AgGridAngular;

  columnDefs: any[];

  private _unsub = new Subject();

  constructor(private translate: TranslateService) {
  }

  ngOnInit() {
    const nameId = 'keyListItems.list.headers.name';
    const keyId = 'keyListItems.list.headers.key';
    const valueId = 'keyListItems.list.headers.value';

    this.translate.get([
      nameId,
      keyId,
      valueId])
      .pipe(takeUntil(this._unsub))
      .subscribe(
        values => {
          this.columnDefs = [
            {
              headerName: '', field: '', sortable: true, filter: true, checkboxSelection: true, width: 30
            },
            {
              headerName: values[nameId],
              field: 'name',
              sortable: true,
              filter: true,
              width: 150
            },
            {
              headerName: values[keyId],
              field: 'key',
              sortable: true,
              filter: true,
              width: 100
            },
            {
              headerName: values[valueId],
              field: 'value',
              sortable: true,
              filter: true,
              width: 150
            },
          ];
        }
      );
  }

  ngOnDestroy(): void {
    this._unsub.next();
    this._unsub.complete();
  }

  selectionChanged($event: any) {
    const selectedRows = $event.api.getSelectedRows();
    if (selectedRows.length > 0) {
      this.rowSelected.emit(selectedRows[0]);
    } else {
      this.rowSelected.emit(undefined);
    }
  }
}
