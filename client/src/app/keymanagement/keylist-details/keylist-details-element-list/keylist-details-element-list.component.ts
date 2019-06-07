import {Component, OnInit, ViewChild} from '@angular/core';
import {KeyListEto} from '../../common/to/KeyListEto';
import {AgGridAngular} from 'ag-grid-angular';

@Component({
  selector: 'app-keylist-details-element-list',
  templateUrl: './keylist-details-element-list.component.html',
  styleUrls: ['./keylist-details-element-list.component.css']
})
export class KeylistDetailsElementListComponent implements OnInit {

  keyListEntries: any[];
  @ViewChild(AgGridAngular, {static: false})
  agGrid: AgGridAngular;

  columnDefs = [
    {headerName: '', field: '', sortable: true, filter: true, checkboxSelection: true},
    {headerName: 'Id', field: 'id', sortable: true, filter: true},
    {headerName: 'Name', field: 'name', sortable: true, filter: true},
    {headerName: 'Comment', field: 'comment', sortable: true, filter: true},
    {headerName: 'Cacheable', field: 'cacheable', sortable: true, filter: true}
  ];

  constructor() { }

  ngOnInit() {
  }

}
