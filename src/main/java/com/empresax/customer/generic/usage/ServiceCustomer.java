package com.empresax.customer.generic.usage;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresax.customer.entity.Customer;
import com.empresax.customer.generic.IRepository;
import com.empresax.customer.generic.IService;

@Service
public class ServiceCustomer implements IService<Customer> {

	@Autowired
	IRepository<Customer> customerRepository;

	@Override
	public Customer saveRecord(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> fetchAllRecords() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateRecord(Customer customer, long customerId) {
		Customer customerDB = findById(customerId);
		if (!Objects.isNull(customerDB)) {
			customerDB = customer;
			return customerRepository.save(customerDB);
		}
		throw new NullPointerException();
	}

	@Override
	public Customer findById(long customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public String deleteRecord(long customerId) {

		Customer customerDB = findById(customerId);
		if (!Objects.isNull(customerDB)) {
			// System.out.println(customerDB.toString());
			customerRepository.deleteById(customerId);
			return customerDB.toString();
		}

		return "No exist";

	}

}
