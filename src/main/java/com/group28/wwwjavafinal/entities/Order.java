package com.group28.wwwjavafinal.entities;

public class Order extends BaseEntity {

	public enum Status {
		Pending, Shipped, Canceled
	}

	private Address shipAddress;
	private Status status;
	private String customerId;

	public Order() {
	}
	
	public Order(Address shipAddress, Status status, String customerId) {
		this.shipAddress = shipAddress;
		this.status = status;
		this.customerId = customerId;
	}

	public Address getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(Address shipAddress) {
		this.shipAddress = shipAddress;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
