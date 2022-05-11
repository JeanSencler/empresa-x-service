package com.empresax.customer.service.address;

import java.util.List;

import com.empresax.customer.entity.Address;

public interface IAddressService {

	// Save Customer
	Address saveAddress(Address address);

	// List Customer
	List<Address> fetchAllAddresses();

	// Update Customer
	Address updateAddress(Address customer, final long addressId);
	
	Address findById(final long addressId);

	// Delete Customer
	String deleteAddress(final long addressId);
}