package com.group28.wwwjavafinal.entities;

public class Customer extends BaseEntity {
	private String name;
	private String accountId;
	private Address address;

	public Customer() {
	}

	public Customer(String name, String accountId, Address address) {
		this.name = name;
		this.accountId = accountId;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
