import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {KeylistDetailsComponent} from './keylist-details/keylist-details.component';
import {KeylistOverviewComponent} from './keylist-overview/keylist-overview.component';
import {KeymanagementRestService} from './keymanagement.rest.service';

@NgModule({
  declarations: [KeylistOverviewComponent, KeylistDetailsComponent],
  imports: [
    CommonModule, RouterModule
  ],
  providers: [
    KeymanagementRestService
  ]
})
export class KeymanagementModule { }
