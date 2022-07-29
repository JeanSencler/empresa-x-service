package com.empresax.customer.service.address;

import com.empresax.customer.entity.Address;
import com.empresax.customer.repository.IAddressRepository;
import com.empresax.customer.service.IServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceImpl implements IServiceTemplate<Address> {

	@Autowired
	private IAddressRepository addressRepository;

	@Override
	public Address saveRecord(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> fetchAllRecords() {
		return addressRepository.findAll();
	}

	@Override
	public Address updateRecord(Address address, long addressId) {
		Address addressDB = findById(addressId);
		if (!Objects.isNull(addressDB)) {
			return addressRepository.save(address);
		}
		throw new NullPointerException();
	}

	@Override
	public Address findById(long addressId) {
		return addressRepository.findById(addressId).orElse(null);
	}

	@Override
	public String deleteRecord(long addressId) {

	
		Address customerDB = findById(addressId);
			if (!Objects.isNull(customerDB)) {
				//System.out.println(customerDB.toString());
				addressRepository.deleteById(addressId);
				return customerDB.toString();
			}
				
			return "No exist";
		
	}

}