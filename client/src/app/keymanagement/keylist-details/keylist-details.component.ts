import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {KeyListEto} from '../common/to/KeyListEto';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';
import {KeyItemEto} from '../common/to/KeyItemEto';
import {KeyListCto} from '../common/to/KeyListCto';

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
    private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.data
      .pipe(takeUntil(this._unsub))
      .subscribe((data: { keyList: KeyListCto }) => {
        this.keyList = data.keyList.keyList;
        this.keyListItems = data.keyList.keyItems;
      });
  }

  ngOnDestroy(): void {
    this._unsub.next();
    this._unsub.complete();
  }

  onRowSelected(item?: KeyItemEto) {
    this.selected = item;
  }
}
