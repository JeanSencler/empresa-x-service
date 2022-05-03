package com.empresax.customer.service.customer;

import java.util.List;

import com.empresax.customer.entity.Customer;

public interface ICustomerService {

	// Save Customer
	Customer saveCustomer(Customer customer);

	// List Customer
	List<Customer> fetchCustomer();

	// Update Customer
	Customer updateCustomer(Customer customer, final long customerId);
	
	Customer findById(final long customerId);

	// Delete Customer
	String deleteCustomer(final long customerId);
}