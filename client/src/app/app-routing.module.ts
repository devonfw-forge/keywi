/**
 * Main routing module of application- responsible for configuration of basic url to component mappings
 */
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationGuard} from './general/authentication/authentication-guard.service';
import {LoginComponent} from './general/login/login.component';
import {KeylistOverviewComponent} from './keymanagement/keylist-overview/keylist-overview.component';
import {KEYLIST_OVERVIEW, keymanagementRoutes} from './keymanagement/keymanagement-routing.module';

const appRoutes: Routes = [
  {
    path: 'login', component: LoginComponent
  },
  {
    path: '',
    redirectTo: KEYLIST_OVERVIEW,
    canActivate: [AuthenticationGuard],
    pathMatch: 'full'
  },
  ...keymanagementRoutes,
  {
    path: '**', component: KeylistOverviewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, {})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

