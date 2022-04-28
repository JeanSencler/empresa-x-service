import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from '../address';
import { AddressService } from '../address.service';

@Component({
  selector: 'app-address-form',
  templateUrl: './address-form.component.html',
  styleUrls: ['./address-form.component.css']
})
export class AddressFormComponent {

  address: Address;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private addressService: AddressService) {
    this.address = new Address();
  }

  onSubmit() {
    this.addressService.save(this.address).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/addresses']);
  }

}
