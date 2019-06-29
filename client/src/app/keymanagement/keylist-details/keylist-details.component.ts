import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {KeyListEto} from '../common/to/KeyListEto';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';
import {KeyItemEto} from '../common/to/KeyItemEto';
import {KeyListCto} from '../common/to/KeyListCto';
import {KeymanagementRestService} from '../keymanagement.rest.service';

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
    private readonly service: KeymanagementRestService,
    private readonly route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.data
      .pipe(takeUntil(this._unsub))
      .subscribe((data: { keyList: KeyListCto }) => {
        this.keyList = data.keyList.keyList;
        this.keyListItems = data.keyList.keyItems;
        console.log(this.keyList);
      });
  }

  ngOnDestroy(): void {
    this._unsub.next();
    this._unsub.complete();
  }

  onRowSelected(item?: KeyItemEto) {
    this.selected = item;
  }

  onDetailsCancel() {

  }

  onDetailsSaved(keyItem: KeyItemEto) {
    console.log(keyItem);
    this.service.saveKeyItem(keyItem)
      .pipe(takeUntil(this._unsub))
      .subscribe(
        saved => this.patchItems(saved),
        error1 => console.log(error1));
  }

  onNew() {
    this.selected = {
      name: '',
      key: '',
      value: '',
      comment: '',
      disabled: false
    };
  }

  onDeactivate() {

  }

  onDelete() {
    const id = this.selected.id;
    this.service.deleteKeyItem(this.selected.id)
      .pipe(takeUntil(this._unsub))
      .subscribe(
        value => {
          this.removeItem(id);
          this.selected = null;
        },
        error1 => console.log(error1));
  }

  private patchItems(item: KeyItemEto) {
    this.keyListItems = this.keyListItems.map(value => value.id === item.id ? item : value);
  }

  private removeItem(id: number) {
    this.keyListItems = this.keyListItems.filter(value => value.id !== id);
  }
}
