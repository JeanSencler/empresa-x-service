package com.empresax.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	private String address;
	private String country;
	private String addressType;
	private char state;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(long addressId, String address, String country, String addressType, char state) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.country = country;
		this.addressType = addressType;
		this.state = state;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" + address + ", country=" + country + ", addressType="
				+ addressType + ", state=" + state + "]";
	}
}