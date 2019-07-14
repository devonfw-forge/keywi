import {AuthenticationGuard} from '../general/authentication/authentication-guard.service';
import {KeylistItemsComponent} from './keylist-items/keylist-items.component';
import {KeylistOverviewComponent} from './keylist-overview/keylist-overview.component';
import {Routes} from '@angular/router';
import {KeylistItemsResolverService} from './keylist-items/keylist-items-resolver.service';
import {KeylistDetailsComponent} from './keylist-details/keylist-details.component';
import {KeylistDetailsResolverService} from './keylist-details/keylist-details-resolver.service';

export const KEYLIST_OVERVIEW = 'keylist-overview';
export const KEYLIST_ITEMS = 'keylist-items';
export const KEYLIST_DETAILS = 'keylist-details';

export const keymanagementRoutes: Routes = [
  {path: KEYLIST_OVERVIEW, component: KeylistOverviewComponent, canActivate: [AuthenticationGuard]},
  {
    path: KEYLIST_ITEMS + '/:id',
    component: KeylistItemsComponent,
    canActivate: [AuthenticationGuard],
    resolve: {
      keyList: KeylistItemsResolverService
    }
  },
  {
    path: KEYLIST_DETAILS + '/:id',
    component: KeylistDetailsComponent,
    canActivate: [AuthenticationGuard],
    resolve: {
      keyList: KeylistDetailsResolverService
    }
  }
];

