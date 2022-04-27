package com.empresax.customer.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresax.customer.entity.Customer;
import com.empresax.customer.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> fetchCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer, long customerId) {
		Customer customerDB = findById(customerId);
		if (!customerDB.equals(null)) {
			customer.setAddress(customerDB.getAddress());
			return customerRepository.save(customer);
		}
		throw new NullPointerException();
	}

	@Override
	public Customer findById(long customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public String deleteCustomer(long customerId) {

	
			Customer customerDB = findById(customerId);
			if (!Objects.isNull(customerDB)) {
				System.out.println(customerDB.toString());
				customerRepository.deleteById(customerId);
				return customerDB.toString();
			}
				
			return "No existe";
		
	}

}