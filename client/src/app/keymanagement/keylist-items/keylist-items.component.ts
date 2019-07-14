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
  templateUrl: './keylist-items.component.html',
  styleUrls: ['./keylist-items.component.css']
})
export class KeylistItemsComponent implements OnInit, OnDestroy {

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
    this.selected = null;
  }

  onDetailsSaved(keyItem: KeyItemEto) {
    const isNew = !keyItem.id;
    this.service.saveKeyItem(keyItem)
      .pipe(takeUntil(this._unsub))
      .subscribe(
        saved => {
          this.keyListItems = isNew ? this.addItem(saved) : this.patchItems(saved);
          this.selected = null;
        },
        error1 => console.log(error1));
  }

  onNew() {
    this.selected = {
      keyListId: this.keyList.id,
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
          this.keyListItems = this.removeItem(id);
          this.selected = null;
        },
        error1 => console.log(error1));
  }

  private addItem(item: KeyItemEto): KeyItemEto[] {
    // TODO client side sorting not performed
    const res = this.patchItems(item);
    res.push(item);
    return res;
  }

  private patchItems(item: KeyItemEto): KeyItemEto[] {
    return this.keyListItems.map(value => value.id === item.id ? item : value);
  }

  private removeItem(id: number): KeyItemEto[] {
    return this.keyListItems.filter(value => value.id !== id);
  }
}
