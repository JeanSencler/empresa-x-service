import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { AddressListComponent } from './address-list/address-list.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { AddressFormComponent } from './address-form/address-form.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    AddressListComponent,
    CustomerFormComponent,
    AddressFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
