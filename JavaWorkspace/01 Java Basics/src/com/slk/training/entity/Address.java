package com.slk.training.entity;

public class Address {
	private String houseNumber;
	private String street;
	private String area;
	private String city = "Bangalore";
	private String state = "Karnataka";
	private String country = "India";
	
	public Address() {
	}

	public Address(String houseNumber, String street, String area) {
		this.houseNumber = houseNumber;
		this.street = street;
		this.area = area;
	}

	public Address(String houseNumber, String street, String area, String city, String state, String country) {
		this.houseNumber = houseNumber;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void print() {
		System.out.println("Address: ");
		
		System.out.println(houseNumber);
		System.out.println(street);
		System.out.println(area);
		System.out.println(city);
		System.out.println(state);
		System.out.println(country);
	}
	
}








