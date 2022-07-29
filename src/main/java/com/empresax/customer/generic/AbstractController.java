package com.empresax.customer.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class AbstractController<T> {
	private final AbstractServiceImpl<T> customerService;

	@Autowired
	public AbstractController(AbstractServiceImpl<T> customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<List<T>> getAll() {
		return ResponseEntity.ok(this.customerService.fetchAllRecords());
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> getById(final @PathVariable long id) {
		return ResponseEntity.ok(this.customerService.findById(id));
	}

	@PostMapping
	public ResponseEntity<T> create(final @RequestBody T customer) {
		return ResponseEntity.ok(this.customerService.saveRecord(customer));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<T> update(final @RequestBody T customer , final @PathVariable long id) {
		System.out.println(customer);
		return ResponseEntity.ok(this.customerService.updateRecord(customer,id));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletetById(final @PathVariable long id) {
		return ResponseEntity.ok(this.customerService.deleteRecord(id));
	}
}