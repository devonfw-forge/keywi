import {Component, OnDestroy, OnInit} from '@angular/core';
import {KeyListEto} from '../common/to/KeyListEto';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {takeUntil} from 'rxjs/operators';
import {KeyListCto} from '../common/to/KeyListCto';
import {Subject} from 'rxjs';
import {FormBuilder, FormGroup} from '@angular/forms';
import {KEYLIST_OVERVIEW} from '../keymanagement-routing.module';

@Component({
  selector: 'app-keylist-details',
  templateUrl: './keylist-details.component.html',
  styleUrls: ['./keylist-details.component.css']
})
export class KeylistDetailsComponent implements OnInit, OnDestroy {

  keyList: KeyListEto;
  formGroup: FormGroup;

  private _unsub = new Subject();

  constructor(
    private readonly service: KeymanagementRestService,
    private readonly route: ActivatedRoute,
    private readonly router: Router,
    fb: FormBuilder) {
    this.formGroup = fb.group({
      key: [''],
      name: [''],
      comment: ['']
    })
  }

  ngOnInit() {
    this.route.data
      .pipe(takeUntil(this._unsub))
      .subscribe((data: { keyList: KeyListEto }) => {
        this.keyList = data.keyList;
        this.updateForm();
      });
  }

  ngOnDestroy(): void {
    this._unsub.next();
    this._unsub.complete();
  }

  onCancel($event: MouseEvent) {
    this.router.navigate([KEYLIST_OVERVIEW]);
  }

  onSave($event: MouseEvent) {
    const modified = {...this.keyList, ...this.formGroup.getRawValue()};
    console.log(modified);
    this.service.saveKeyList(modified)
      .pipe(takeUntil(this._unsub))
      .subscribe(value => {
        this.router.navigate([KEYLIST_OVERVIEW]);
      }, error1 => {
        console.log(error1);
      });
  }

  private updateForm() {
    if (this.keyList) {
      this.formGroup.patchValue(this.keyList);
    }
  }
}
