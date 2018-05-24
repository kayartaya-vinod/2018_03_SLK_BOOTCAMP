package com.slk.training.programs;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello, World!");
		sayHello("Vinod");
		sayHello("Shyam");

		System.out.println(getHelloMessage("Ravi"));
		System.out.println(getHelloMessage("Shashi"));

	}

	static String getHelloMessage(String name) {
		return "Hello, " + name + "!";
	}

	static void sayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}

}
