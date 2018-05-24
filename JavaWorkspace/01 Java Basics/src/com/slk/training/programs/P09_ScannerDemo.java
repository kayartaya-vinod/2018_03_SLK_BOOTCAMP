package com.slk.training.programs;

import java.util.Scanner;

public class P09_ScannerDemo {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String name;
		int age;
		double height;
		
		System.out.println("Enter your age: ");
		age = scanner.nextInt();
		// scanner.nextLine(); // skip the blank line
		
		scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		name = scanner.nextLine();
		
		System.out.print("Enter your height: ");
		height = scanner.nextDouble();
		
		System.out.println("Name = " + name);
		System.out.println("Age = " + age + " years.");
		System.out.println("Height = " + height + "ft.");
		
	}

}
