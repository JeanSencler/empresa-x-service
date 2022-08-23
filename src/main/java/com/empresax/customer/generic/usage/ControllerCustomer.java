package com.empresax.customer.generic.usage;

import java.util.List;

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
import com.empresax.customer.generic.IController;
import com.empresax.customer.generic.IService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/v2/customers")
public class ControllerCustomer implements IController<Customer>{

	private final IService<Customer> customerService;
	
	public ControllerCustomer(IService<Customer> customerService) {
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
