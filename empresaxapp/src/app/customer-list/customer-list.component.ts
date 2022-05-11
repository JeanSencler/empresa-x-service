import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers !: Customer[];

  constructor(private customerService: CustomerService, private router: Router) {
  }

  ngOnInit(): void {
    this.customerService.findAll().subscribe(data =>{
      this.customers = data;
    });
  }
}
