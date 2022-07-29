package com.empresax.customer.controller;

import java.util.List;

import com.empresax.customer.service.IServiceTemplate;
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

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/addresses")
public class AddressController {
	private final IServiceTemplate<Address> addressService;

	@Autowired
	public AddressController(IServiceTemplate<Address> addressService) {
		this.addressService = addressService;
	}

	@GetMapping
	public ResponseEntity<List<Address>> getAll() {
		return ResponseEntity.ok(this.addressService.fetchAllRecords());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> getById(final @PathVariable long id) {
		return ResponseEntity.ok(this.addressService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Address> create(final @RequestBody Address customer) {
		return ResponseEntity.ok(this.addressService.saveRecord(customer));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Address> update(final @RequestBody Address customer , final @PathVariable long id) {
		System.out.println(customer);
		return ResponseEntity.ok(this.addressService.updateRecord(customer,id));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletetById(final @PathVariable long id) {
		return ResponseEntity.ok(this.addressService.deleteRecord(id));
	}
}