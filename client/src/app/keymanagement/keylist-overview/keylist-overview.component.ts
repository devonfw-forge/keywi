import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {AgGridAngular} from 'ag-grid-angular';
import {KeyListEto} from '../common/to/KeyListEto';
import {KEYLIST_DETAILS, KEYLIST_ITEMS} from '../keymanagement-routing.module';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';

@Component({
  selector: 'app-keylist-overview',
  templateUrl: './keylist-overview.component.html',
  styleUrls: ['./keylist-overview.component.css']
})
export class KeylistOverviewComponent implements OnInit, OnDestroy {

  keyLists: KeyListEto[];
  @ViewChild(AgGridAngular, {static: false})
  agGrid: AgGridAngular;

  private readonly _unsub = new Subject();

  columnDefs = [
    {headerName: '', field: '', sortable: true, filter: true, checkboxSelection: true},
    {headerName: 'Id', field: 'id', sortable: true, filter: true},
    {headerName: 'Name', field: 'name', sortable: true, filter: true},
    {headerName: 'Comment', field: 'comment', sortable: true, filter: true},
    {headerName: 'Cacheable', field: 'cacheable', sortable: true, filter: true}
  ];

  constructor(private readonly keyManagementRestService: KeymanagementRestService,
              private readonly router: Router) {
  }

  ngOnInit() {
    this.keyManagementRestService.findAllKeylists().subscribe(this.getData());
  }

  ngOnDestroy(): void {
    this._unsub.next();
    this._unsub.complete();
  }

  goToItems() {
    const selectedId = this.getSelectedKeylistId();
    if (selectedId) {
      this.router.navigate([KEYLIST_ITEMS + '/' + selectedId]);
    }
  }

  createNew() {
    this.router.navigate([KEYLIST_DETAILS]);
  }

  goToDetails() {
    const selectedId = this.getSelectedKeylistId();
    if (selectedId) {
      this.router.navigate([KEYLIST_DETAILS + '/' + selectedId]);
    }
  }

  delete() {
    const selectedId = this.getSelectedKeylistId();
    this.keyManagementRestService.deleteKeyList(selectedId)
      .pipe(takeUntil(this._unsub))
      .subscribe(
        this.removeElement(selectedId),
        error1 => console.log(error1)
      );
  }

  private getSelectedKeylistId() {
    const selectedKeyList = this.agGrid.api.getSelectedNodes();
    return selectedKeyList.map(node => node.data.id)[0];
  }

  private getData() {
    return value => this.keyLists = value;
  }

  private removeElement(id: number) {
    return _ => this.keyLists = this.keyLists.filter(value => value.id !== id);
  }
}
