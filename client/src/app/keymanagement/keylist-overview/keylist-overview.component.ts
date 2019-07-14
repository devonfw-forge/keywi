import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {AgGridAngular} from 'ag-grid-angular';
import {GridApi} from 'ag-grid-community';
import {KeyListEto} from '../common/to/KeyListEto';
import {KEYLIST_ITEMS} from '../keymanagement-routing.module';
import {KeymanagementRestService} from '../keymanagement.rest.service';

@Component({
  selector: 'app-keylist-overview',
  templateUrl: './keylist-overview.component.html',
  styleUrls: ['./keylist-overview.component.css']
})
export class KeylistOverviewComponent implements OnInit {

  keyLists: KeyListEto[];
  @ViewChild(AgGridAngular, {static: false})
  agGrid: AgGridAngular;

  columnDefs = [
    {headerName: '', field: '', sortable: true, filter: true, checkboxSelection: true},
    {headerName: 'Id', field: 'id', sortable: true, filter: true},
    {headerName: 'Name', field: 'name', sortable: true, filter: true},
    {headerName: 'Comment', field: 'comment', sortable: true, filter: true},
    {headerName: 'Cacheable', field: 'cacheable', sortable: true, filter: true}
  ];

  constructor(private keyManagementRestService: KeymanagementRestService,
              private router: Router) {
  }

  ngOnInit() {
    this.keyManagementRestService.findAllKeylists().subscribe(this.getData());
  }

  goToItems() {
    const selectedKeyList = this.agGrid.api.getSelectedNodes();
    const selectedId = selectedKeyList.map(node => node.data.id)[0];
    if (selectedId) {
      this.router.navigate([KEYLIST_ITEMS + '/' + selectedId]);
    }
  }

  createNew() {

  }

  goToDetails() {

  }

  delete() {

  }

  private getData() {
    return (value) => this.keyLists = value;
  }
}
