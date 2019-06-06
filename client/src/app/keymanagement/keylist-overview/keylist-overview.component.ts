import { Component, OnInit } from '@angular/core';
import {KeyListEto} from '../common/to/KeyListEto';
import {KeymanagementRestService} from '../keymanagement.rest.service';

@Component({
  selector: 'app-keylist-overview',
  templateUrl: './keylist-overview.component.html',
  styleUrls: ['./keylist-overview.component.css']
})
export class KeylistOverviewComponent implements OnInit {
  keyLists: KeyListEto[];
  constructor(private keyManagementRestService: KeymanagementRestService) { }

  ngOnInit() {
    this.keyManagementRestService.findAllKeylists().subscribe(this.getData());
  }

  private getData() {
    return (value) => this.keyLists = value;
  }
}
