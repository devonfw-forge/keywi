import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {KeyItemEto} from '../../common/to/KeyItemEto';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-keylist-details-element-details',
  templateUrl: './keylist-items-details.component.html',
  styleUrls: ['./keylist-items-details.component.css']
})
export class KeylistItemsDetailsComponent implements OnInit, OnChanges {

  @Input()
  value: KeyItemEto;
  @Output()
  saveClicked = new EventEmitter<KeyItemEto>();
  @Output()
  cancelClicked = new EventEmitter();

  formGroup: FormGroup;

  constructor(fb: FormBuilder) {
    this.formGroup = fb.group({
      key: new FormControl({value: '', disabled: !this.isNew}),
      name: ['', Validators.required],
      value: ['', Validators.required],
      comment: ['', []],
      disabled: [false, []]
    });
  }

  get isNew(): boolean {
    return this.value && !this.value.id;
  }

  get keyFormControl(): AbstractControl {
    return this.formGroup.get('key');
  }

  ngOnInit() {
    this.updateForm();
  }

  onCancel() {
    this.updateForm();
    this.cancelClicked.emit();
  }

  onSave() {
    const result = {...this.value, ...this.formGroup.value};
    this.saveClicked.emit(result);
  }

  private updateForm() {
    if (this.value && this.formGroup) {
      this.formGroup.reset({...this.value});
      if (this.isNew) {
        this.keyFormControl.enable();
      } else {
        this.keyFormControl.disable();
      }
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.updateForm();
  }
}
