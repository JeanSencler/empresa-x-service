import { Component, OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit{

  customer !: Customer;
  id !: number;
  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private customerService: CustomerService) {
    //this.customer = new Customer();
  }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];

      if (!this.id == null) {
        this.customerService.findCustomer(this.id).subscribe(data => { this.customer = data });

      }
      else{
        this.customer = new Customer();
      }
  }

  onSubmit() {
    this.customerService.save(this.customer).subscribe(result => this.gotoCustomerList());
  }

  gotoCustomerList() {
    this.router.navigate(['/customers']);
  }


}
