package com.slk.training.entity;

public class Person  {
	private String name;
	private String email;
	private String phone;

	// aggregation
	private Address address = new Address(); // good practice to assign a new object during aggregation

	public Person() {
	}

	public Person(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

	public void print() {
		System.out.println("Name  = " + name);
		System.out.println("Email = " + email);
		System.out.println("Phone = " + phone);
		address.print();
	}

}
