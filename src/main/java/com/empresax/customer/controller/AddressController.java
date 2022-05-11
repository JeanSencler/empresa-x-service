package com.empresax.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresax.customer.entity.Address;
import com.empresax.customer.service.address.IAddressService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/addresses")
public class AddressController {
	private final IAddressService addressService;

	@Autowired
	public AddressController(IAddressService addressService) {
		this.addressService = addressService;
	}

	@GetMapping
	public ResponseEntity<List<Address>> getAll() {
		return ResponseEntity.ok(this.addressService.fetchAllAddresses());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> getById(final @PathVariable long id) {
		return ResponseEntity.ok(this.addressService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Address> create(final @RequestBody Address customer) {
		return ResponseEntity.ok(this.addressService.saveAddress(customer));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Address> update(final @RequestBody Address customer , final @PathVariable long id) {
		System.out.println(customer);
		return ResponseEntity.ok(this.addressService.updateAddress(customer,id));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletetById(final @PathVariable long id) {
		return ResponseEntity.ok(this.addressService.deleteAddress(id));
	}
}