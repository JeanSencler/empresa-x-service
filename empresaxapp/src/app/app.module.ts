import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { AddressListComponent } from './address-list/address-list.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { AddressFormComponent } from './address-form/address-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { AddressDetailComponent } from './address-detail/address-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    AddressListComponent,
    CustomerFormComponent,
    AddressFormComponent,
    CustomerDetailComponent,
    AddressDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
