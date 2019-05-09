package com.group28.wwwjavafinal.entities;

public class Order extends BaseEntity {

	public enum Status {
		None, Pending, Shipped, Canceled;
		
		public static Status parse(String target) {
			if (target.equalsIgnoreCase(Pending.toString()))
				return Pending;
			
			if (target.equalsIgnoreCase(Shipped.toString()))
				return Shipped;
			
			if (target.equalsIgnoreCase(Canceled.toString()))
				return Canceled;
			
			return None;
		}
	}

	private Address shipAddress;
	private Status status;
	private int customerId;

	public Order() {
	}
	
	public Order(Address shipAddress, Status status, int customerId) {
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
