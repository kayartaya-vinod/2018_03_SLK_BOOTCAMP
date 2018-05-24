package com.slk.training.programs;

import com.slk.training.entity.Customer;

public class P01_CreateObjects {

	public static void main(String[] args) {
		
		System.out.println("vinod".hashCode());
		Customer c1;
		c1 = new Customer();

		c1.name = "Vinod"; // new String("Vinod");
		c1.email = "vinod@vinod.co";
		c1.mobile = "9731424784";
		

		System.out.println("Name = " + c1.name);
		System.out.println("Email = " + c1.email);
		System.out.println("Mobile = " + c1.mobile);
		System.out.println();
	}
}
