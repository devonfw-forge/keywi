import {AuthenticationGuard} from '../general/authentication/authentication-guard.service';
import {KeylistDetailsComponent} from './keylist-details/keylist-details.component';
import {KeylistOverviewComponent} from './keylist-overview/keylist-overview.component';
import {Routes} from '@angular/router';
import {KeylistDetailsResolverService} from './keylist-details/keylist-details-resolver.service';

export const KEYLIST_OVERVIEW = 'keylist-overview';
export const KEYLIST_DETAILS = 'keylist-details';

export const keymanagementRoutes: Routes = [
  {path: KEYLIST_OVERVIEW, component: KeylistOverviewComponent, canActivate: [AuthenticationGuard]},
  {
    path: KEYLIST_DETAILS + '/:id',
    component: KeylistDetailsComponent,
    canActivate: [AuthenticationGuard],
    resolve: {
      keyList: KeylistDetailsResolverService
    }
  }
];

