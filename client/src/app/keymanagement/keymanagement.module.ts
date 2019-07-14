import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AgGridModule} from 'ag-grid-angular';
import {KeylistItemsComponent} from './keylist-items/keylist-items.component';
import {KeylistOverviewComponent} from './keylist-overview/keylist-overview.component';
import {KeylistItemsListComponent} from './keylist-items/keylist-items-list/keylist-items-list.component';
import {KeylistItemsDetailsComponent} from './keylist-items/keylist-items-details/keylist-items-details.component';
import {KeywiMaterialModule} from '../general/keywi-material.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TranslateModule} from '@ngx-translate/core';
import { KeylistDetailsComponent } from './keylist-details/keylist-details.component';

@NgModule({
  declarations: [
    KeylistOverviewComponent,
    KeylistItemsComponent,
    KeylistItemsListComponent,
    KeylistItemsDetailsComponent,
    KeylistDetailsComponent],
  imports: [
    CommonModule,
    RouterModule,
    AgGridModule.withComponents([KeylistOverviewComponent, KeylistItemsListComponent]),
    KeywiMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    TranslateModule
  ]
})
export class KeymanagementModule {
}
