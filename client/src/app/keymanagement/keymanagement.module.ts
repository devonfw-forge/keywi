import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AgGridModule} from 'ag-grid-angular';
import {KeylistDetailsComponent} from './keylist-details/keylist-details.component';
import {KeylistOverviewComponent} from './keylist-overview/keylist-overview.component';
import {KeylistDetailsElementListComponent} from './keylist-details/keylist-details-element-list/keylist-details-element-list.component';
import {KeylistDetailsElementDetailsComponent} from './keylist-details/keylist-details-element-details/keylist-details-element-details.component';
import {KeywiMaterialModule} from '../general/keywi-material.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TranslateModule} from '@ngx-translate/core';

@NgModule({
  declarations: [
    KeylistOverviewComponent,
    KeylistDetailsComponent,
    KeylistDetailsElementListComponent,
    KeylistDetailsElementDetailsComponent],
  imports: [
    CommonModule,
    RouterModule,
    AgGridModule.withComponents([KeylistOverviewComponent, KeylistDetailsElementListComponent]),
    KeywiMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    TranslateModule
  ]
})
export class KeymanagementModule {
}
