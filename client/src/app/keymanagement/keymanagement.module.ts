import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AgGridModule} from 'ag-grid-angular';
import {KeylistDetailsComponent} from './keylist-details/keylist-details.component';
import {KeylistOverviewComponent} from './keylist-overview/keylist-overview.component';
import {KeymanagementRestService} from './keymanagement.rest.service';
import {KeylistDetailsElementListComponent} from './keylist-details/keylist-details-element-list/keylist-details-element-list.component';
import {KeylistDetailsElementDetailsComponent} from './keylist-details/keylist-details-element-details/keylist-details-element-details.component';
import {FlexLayoutModule} from '@angular/flex-layout';

@NgModule({
  declarations: [
    KeylistOverviewComponent,
    KeylistDetailsComponent,
    KeylistDetailsElementListComponent,
    KeylistDetailsElementDetailsComponent],
  imports: [
    CommonModule,
    RouterModule,
    AgGridModule.withComponents([KeylistOverviewComponent]),
    FlexLayoutModule
  ],
  providers: [
    KeymanagementRestService
  ]
})
export class KeymanagementModule {
}
