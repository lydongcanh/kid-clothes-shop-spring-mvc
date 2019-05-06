package com.group28.wwwjavafinal.entities;

public class Address {
	private String houseNumber;
	private String street;
	private String district;
	private String city;

	public Address() {
	}
	
	public Address(String houseNumber, String street, String district, String city) {
		this.houseNumber = houseNumber;
		this.street = street;
		this.district = district;
		this.city = city;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
