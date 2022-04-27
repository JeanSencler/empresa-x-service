package com.empresax.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empresax.customer.repository.ICustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication{
	
	@Autowired
	ICustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}