package com.empresax.customer.generic;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractServiceImpl<T> {

	@Autowired
	private AbstractRepository<T> entityRepository;
	

	public T saveRecord(T customer) {
		return entityRepository.save(customer);
	}


	public List<T> fetchAllRecords() {
		return entityRepository.findAll();
	}


	public T updateRecord(T customer, long customerId) {
		T customerDB = findById(customerId);
		if (!Objects.isNull(customerDB)) {
			customerDB = customer;
			return entityRepository.save(customerDB);
		}
		throw new NullPointerException();
	}


	public T findById(long customerId) {
		return entityRepository.findById(customerId).orElse(null);
	}


	public String deleteRecord(long customerId) {

	
			T customerDB = findById(customerId);
			if (!Objects.isNull(customerDB)) {
				//System.out.println(customerDB.toString());
				entityRepository.deleteById(customerId);
				return customerDB.toString();
			}
				
			return "No exist";
		
	}
	

}