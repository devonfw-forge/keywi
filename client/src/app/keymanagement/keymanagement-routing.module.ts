import {AuthenticationGuard} from '../general/authentication/authentication-guard.service';
import {KeylistItemsComponent} from './keylist-items/keylist-items.component';
import {KeylistOverviewComponent} from './keylist-overview/keylist-overview.component';
import {Routes} from '@angular/router';
import {KeylistItemsResolverService} from './keylist-items/keylist-items-resolver.service';

export const KEYLIST_OVERVIEW = 'keylist-overview';
export const KEYLIST_DETAILS = 'keylist-details';

export const keymanagementRoutes: Routes = [
  {path: KEYLIST_OVERVIEW, component: KeylistOverviewComponent, canActivate: [AuthenticationGuard]},
  {
    path: KEYLIST_DETAILS + '/:id',
    component: KeylistItemsComponent,
    canActivate: [AuthenticationGuard],
    resolve: {
      keyList: KeylistItemsResolverService
    }
  }
];

