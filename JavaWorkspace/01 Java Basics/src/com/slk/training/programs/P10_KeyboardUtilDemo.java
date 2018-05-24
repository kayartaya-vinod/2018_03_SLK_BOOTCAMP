package com.slk.training.programs;

import com.slk.training.util.KeyboardUtil;

public class P10_KeyboardUtilDemo {

	public static void main(String[] args) {
		String name;
		int age;
		double height;
		
		age = KeyboardUtil.getInt("Enter your age: ");
		name = KeyboardUtil.getString("Enter your name: ");
		height = KeyboardUtil.getDouble("Enter your height: ");
		
		System.out.println("Name = " + name);
		System.out.println("Age = " + age + " years.");
		System.out.println("Height = " + height + "ft.");
				
	}
}
