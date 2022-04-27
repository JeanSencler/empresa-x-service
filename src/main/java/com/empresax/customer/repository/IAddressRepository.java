package com.empresax.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresax.customer.entity.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long>{

}