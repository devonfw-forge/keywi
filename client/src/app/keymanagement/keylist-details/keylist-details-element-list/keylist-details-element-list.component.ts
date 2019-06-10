import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {KeyListEto} from '../../common/to/KeyListEto';
import {AgGridAngular} from 'ag-grid-angular';
import {KeyItemEto} from '../../common/to/KeyItemEto';
import {GridApi} from 'ag-grid-community';

@Component({
  selector: 'app-keylist-details-element-list',
  templateUrl: './keylist-details-element-list.component.html',
  styleUrls: ['./keylist-details-element-list.component.css']
})
export class KeylistDetailsElementListComponent implements OnInit {

  @Input()
  values: KeyItemEto[];

  @Output()
  rowSelected = new EventEmitter<KeyItemEto>();

  @ViewChild(AgGridAngular, {static: false})
  agGrid: AgGridAngular;

  columnDefs = [
    {headerName: '', field: '', sortable: true, filter: true, checkboxSelection: true, width: 30},
    {headerName: 'Key', field: 'key', sortable: true, filter: true, width: 100},
    {headerName: 'Name', field: 'name', sortable: true, filter: true, width: 150},
    {headerName: 'Value', field: 'value', sortable: true, filter: true, width: 150},
  ];

  constructor() { }

  ngOnInit() {
  }

  selectionChanged($event: any) {
    const selectedRows = $event.api.getSelectedRows();
    if (selectedRows.length > 0) {
      this.rowSelected.emit(selectedRows[0]);
    }
  }
}
