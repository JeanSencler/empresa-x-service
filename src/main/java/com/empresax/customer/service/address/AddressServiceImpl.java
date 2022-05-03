package com.empresax.customer.service.address;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresax.customer.entity.Address;
import com.empresax.customer.entity.Customer;
import com.empresax.customer.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressRepository addressRepository;

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> fetchAllAddresses() {
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public Address updateAddress(Address address, long addressId) {
		Address addressDB = findById(addressId);
		if (!addressDB.equals(null)) {
			return addressRepository.save(address);
		}
		throw new NullPointerException();
	}

	@Override
	public Address findById(long addressId) {
		return addressRepository.findById(addressId).orElse(null);
	}

	@Override
	public String deleteAddress(long addressId) {

	
		Address customerDB = findById(addressId);
			if (!Objects.isNull(customerDB)) {
				System.out.println(customerDB.toString());
				addressRepository.deleteById(addressId);
				return customerDB.toString();
			}
				
			return "No existe";
		
	}

}