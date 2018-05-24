package com.slk.training.programs;

import com.slk.training.entity.Product;

public class P02_EncapsulationDemo {
	public static void main(String[] args) {
		Product p1 = new Product();
		p1.setName("Chai");
		p1.setPrice(22);
		
		Product p2 = new Product("Chang", 55.33);
		p2.setPrice(56.78);
		
		p1.print();
		p2.print();
		
		System.out.println(p1);
		System.out.println(p2);
		
		
		
		
	}
}
