import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  customer !: Customer;
  id !: number;

  constructor(private customerService: CustomerService,
    private router: Router,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.customer = new Customer();
    this.id = this.route.snapshot.params['id'];
    this.customerService.findCustomer(this.id).subscribe(data => { this.customer = data });

  }

  deleteCustomer(id: number){
    this.customerService.deleteCustomer(id).subscribe(() => this.gotoCustomerList());
  }
  gotoCustomerList() {
    this.router.navigate(['/customers']);
  }
}
