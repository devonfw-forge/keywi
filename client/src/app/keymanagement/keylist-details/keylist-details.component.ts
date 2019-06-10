import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, convertToParamMap} from '@angular/router';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {KeyListEto} from '../common/to/KeyListEto';
import {Subject} from 'rxjs';
import {map, switchMap, takeUntil} from 'rxjs/operators';
import {KeyItemEto} from '../common/to/KeyItemEto';

@Component({
  selector: 'app-keylist-details',
  templateUrl: './keylist-details.component.html',
  styleUrls: ['./keylist-details.component.css']
})
export class KeylistDetailsComponent implements OnInit, OnDestroy {

  keyList: KeyListEto;
  keyListItems: KeyItemEto[] = [];
  selected?: KeyItemEto = null;

  private _unsub = new Subject();

  constructor(
    private route: ActivatedRoute,
    private keyManagementRestService: KeymanagementRestService) {
  }

  ngOnInit() {
    this.route.data
      .pipe(takeUntil(this._unsub))
      .subscribe((data: { keyList: KeyListEto }) => {
        this.keyList = data.keyList;
      });
    this.route.paramMap
      .pipe(
        takeUntil(this._unsub),
        map(paramMap => paramMap.get('id')),
        switchMap(id => this.keyManagementRestService.findKeyItemsForKeyList(+id)))
      .subscribe(keyItems => this.keyListItems = keyItems);
  }

  ngOnDestroy(): void {
    this._unsub.next();
    this._unsub.complete();
  }

  onRowSelected(item?: KeyItemEto) {
    this.selected = item;
  }
}
