import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddressDetailComponent } from './address-detail/address-detail.component';
import { AddressFormComponent } from './address-form/address-form.component';
import { AddressListComponent } from './address-list/address-list.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CustomerListComponent } from './customer-list/customer-list.component';

const routes: Routes = [
  {path: 'customers', component: CustomerListComponent},
  {path: 'savecustomer', component: CustomerFormComponent},
  {path: 'editcustomer/:id', component: CustomerFormComponent},
  {path: 'customers/:id', component: CustomerDetailComponent},
  {path: 'addresses', component: AddressListComponent},
  {path: 'addresses/:id', component: AddressDetailComponent},
  {path: 'saveaddress', component: AddressFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
