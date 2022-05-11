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

import com.empresax.customer.entity.Customer;
import com.empresax.customer.service.customer.ICustomerService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/customers")
public class CustomerController {
	private final ICustomerService customerService;

	@Autowired
	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(this.customerService.fetchCustomer());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(final @PathVariable long id) {
		return ResponseEntity.ok(this.customerService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Customer> create(final @RequestBody Customer customer) {
		return ResponseEntity.ok(this.customerService.saveCustomer(customer));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> update(final @RequestBody Customer customer , final @PathVariable long id) {
		System.out.println(customer);
		return ResponseEntity.ok(this.customerService.updateCustomer(customer,id));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletetById(final @PathVariable long id) {
		return ResponseEntity.ok(this.customerService.deleteCustomer(id));
	}
}