package com.empresax.customer.generic.usage;

import org.springframework.stereotype.Repository;

import com.empresax.customer.entity.Customer;
import com.empresax.customer.generic.IRepository;

@Repository
public interface CustomerRepository extends IRepository<Customer>{

}
