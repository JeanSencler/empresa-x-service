package com.empresax.customer.generic.usage;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresax.customer.entity.Customer;
import com.empresax.customer.generic.AbstractController;
import com.empresax.customer.generic.AbstractServiceImpl;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/v2/customers")
public class ControllerCustomer extends AbstractController<Customer>{

	public ControllerCustomer(AbstractServiceImpl<Customer> customerService) {
		super(customerService);
	}

}
