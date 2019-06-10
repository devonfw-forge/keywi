import {Component, Input, OnInit} from '@angular/core';
import {KeyItemEto} from '../../common/to/KeyItemEto';

@Component({
  selector: 'app-keylist-details-element-details',
  templateUrl: './keylist-details-element-details.component.html',
  styleUrls: ['./keylist-details-element-details.component.css']
})
export class KeylistDetailsElementDetailsComponent implements OnInit {

  @Input()
  value: KeyItemEto;

  constructor() {
  }

  ngOnInit() {
  }

}
