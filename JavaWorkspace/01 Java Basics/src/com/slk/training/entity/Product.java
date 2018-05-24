package com.slk.training.entity;

public class Product {
	// fields; genrally private in nature
	private String name;
	private double price;

	// default/no-arg constructor
	public Product() {
	}

	// parameterized or overloaded constructor
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// accessor; (access the value of a field) (a.k.a getter or a readable property)
	public String getName() {
		return name;
	}

	// mutator (changes the value of a field) (a.k.a setter or writable property)
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void print() {
		System.out.println("Product details:");
		System.out.println("Name   : " + this.name);
		System.out.println("Price  : Rs." + this.price);
		System.out.println();
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}



}











