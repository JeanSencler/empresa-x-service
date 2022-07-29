package com.empresax.customer.service;

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

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/customers")
public class EntityController {
	private final IServiceTemplate<Customer> customerService;

	@Autowired
	public EntityController(IServiceTemplate<Customer> customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(this.customerService.fetchAllRecords());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(final @PathVariable long id) {
		return ResponseEntity.ok(this.customerService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Customer> create(final @RequestBody Customer customer) {
		return ResponseEntity.ok(this.customerService.saveRecord(customer));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> update(final @RequestBody Customer customer , final @PathVariable long id) {
		System.out.println(customer);
		return ResponseEntity.ok(this.customerService.updateRecord(customer,id));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletetById(final @PathVariable long id) {
		return ResponseEntity.ok(this.customerService.deleteRecord(id));
	}
}