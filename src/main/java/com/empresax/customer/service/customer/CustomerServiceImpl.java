package com.empresax.customer.service.customer;

import java.util.List;
import java.util.Objects;

import com.empresax.customer.service.IServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresax.customer.entity.Customer;
import com.empresax.customer.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements IServiceTemplate<Customer> {

	@Autowired
	private ICustomerRepository customerRepository;

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
			customerDB.setAddress(customer.getAddress());
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
				//System.out.println(customerDB.toString());
				customerRepository.deleteById(customerId);
				return customerDB.toString();
			}
				
			return "No exist";
		
	}

}