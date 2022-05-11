import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from '../address';
import { AddressService } from '../address.service';

@Component({
  selector: 'app-address-detail',
  templateUrl: './address-detail.component.html',
  styleUrls: ['./address-detail.component.css']
})
export class AddressDetailComponent implements OnInit {

  address !: Address;
  id !: number;

  constructor(private addressService: AddressService,
    private router: Router,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.address = new Address();
    this.id = this.route.snapshot.params['id'];
    this.addressService.findAddress(this.id).subscribe(data => { this.address = data });

  }

  deleteAddress(id: number){
    this.addressService.deleteAddress(id).subscribe(() => this.gotoAddressList());
  }
  gotoAddressList() {
    this.router.navigate(['/addresses']);
  }

}
