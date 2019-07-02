import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {GeneralModule} from './general/general.module';
import {KeymanagementModule} from './keymanagement/keymanagement.module';
import {I18nService} from './general/i18n/i18n.service';
import {TranslateModule} from '@ngx-translate/core';
import {HttpRequestInterceptorService} from './general/authentication/http-request-interceptor.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    KeymanagementModule,
    AppRoutingModule,
    GeneralModule,
    TranslateModule.forRoot()
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptorService, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(i18n: I18nService) {
    i18n.configure();
  }
}
