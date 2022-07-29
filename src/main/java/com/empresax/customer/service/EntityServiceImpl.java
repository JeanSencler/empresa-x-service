package com.empresax.customer.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl<Object> implements IServiceTemplate<Object> {

	@Autowired
	private IEntityRepository<Object> entityRepository;
	
	@Override
	public Object saveRecord(Object customer) {
		return entityRepository.save(customer);
	}

	@Override
	public List<Object> fetchAllRecords() {
		return entityRepository.findAll();
	}

	@Override
	public Object updateRecord(Object customer, long customerId) {
		Object customerDB = findById(customerId);
		if (!Objects.isNull(customerDB)) {
			customerDB = customer;
			return entityRepository.save(customerDB);
		}
		throw new NullPointerException();
	}

	@Override
	public Object findById(long customerId) {
		return entityRepository.findById(customerId).orElse(null);
	}

	@Override
	public String deleteRecord(long customerId) {

	
			Object customerDB = findById(customerId);
			if (!Objects.isNull(customerDB)) {
				//System.out.println(customerDB.toString());
				entityRepository.deleteById(customerId);
				return customerDB.toString();
			}
				
			return "No exist";
		
	}
	

}