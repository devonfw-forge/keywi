import {Component, OnDestroy, OnInit} from '@angular/core';
import {allKeyListOrderings, KeyListEto} from '../common/to/KeyListEto';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {takeUntil} from 'rxjs/operators';
import {Subject} from 'rxjs';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {KEYLIST_OVERVIEW} from '../keymanagement-routing.module';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-keylist-details',
  templateUrl: './keylist-details.component.html',
  styleUrls: ['./keylist-details.component.css']
})
export class KeylistDetailsComponent implements OnInit, OnDestroy {

  keyList: KeyListEto;
  formGroup: FormGroup;
  orderings = allKeyListOrderings();

  private _unsub = new Subject();

  constructor(
    private readonly service: KeymanagementRestService,
    private readonly route: ActivatedRoute,
    private readonly router: Router,
    private readonly toastr: ToastrService,
    private readonly fb: FormBuilder) {
    this.formGroup = fb.group({
      key: ['', Validators.required],
      name: ['', Validators.required],
      comment: [''],
      disabled: [false],
      ordering: ['NAME', Validators.required],
      valueRequired: [false],
      permission: [''],
      cacheable: [false]
    });
  }

  get isNew(): boolean {
    return this.keyList && !this.keyList.id;
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

  onCancel() {
    this.router.navigate([KEYLIST_OVERVIEW]);
  }

  onSave() {
    const modified = {...this.keyList, ...this.formGroup.value};
    this.service.saveKeyList(modified)
      .pipe(takeUntil(this._unsub))
      .subscribe(value => {
        this.router.navigate([KEYLIST_OVERVIEW]);
      }, error1 => {
        this.toastr.error(error1);
      });
  }

  private updateForm() {
    if (this.keyList) {
      this.formGroup.patchValue(this.keyList);
    }
  }
}
