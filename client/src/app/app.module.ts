import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {GeneralModule} from './general/general.module';
import {KeymanagementModule} from './keymanagement/keymanagement.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, KeymanagementModule, AppRoutingModule, GeneralModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
