import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {KeymanagementRestService} from '../keymanagement.rest.service';
import {KeyListEto} from '../common/to/KeyListEto';
import {Observable} from 'rxjs';
import {switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-keylist-details',
  templateUrl: './keylist-details.component.html',
  styleUrls: ['./keylist-details.component.css']
})
export class KeylistDetailsComponent implements OnInit {

  keyListEto$: Observable<KeyListEto>;

  constructor(
    private route: ActivatedRoute,
    private keyManagementRestService: KeymanagementRestService) {
  }

  ngOnInit() {
    this.keyListEto$ = this.route.paramMap
      .pipe(
        switchMap(paramList => this.keyManagementRestService.findKeyList(+paramList.get('id')))
      );
  }

}
