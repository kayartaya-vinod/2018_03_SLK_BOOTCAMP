package com.slk.training.programs;

class Circle {
	static double PI = 3.1416;
	double radius;
	
	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void printArea() {
		// can access non-static member variables
		// can also access static variables of this class
		double area = PI * radius * radius;
		System.out.printf("Area of circle with radiys %f is %f\n", radius, area);
	}
	
	public static void printInfo() {
		// invoked using the name of the class
		// can only access other static members of this class
		// cannot access non-static members of the class
		System.out.println("PI = " + PI);
		// System.out.println("Radius = " + radius); // Who's radius?
	}
}

public class P12_StaticAndNonStaticDemo {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		System.out.println("pass1");
		Circle c1;
		System.out.println("pass2");
		Class.forName("com.slk.training.programs.Circle");
		System.out.println("pass3");
		System.out.println("The value of PI is: " + Circle.PI);
		System.out.println("pass4");
		// c1 = (Circle) Class.forName("com.slk.training.programs.Circle").newInstance();
		c1 = new Circle(2.3);
		c1.printArea();
		
		Circle.printInfo();
		// c1.printInfo(); // allowed; but not recommended!
		
		
	}
}








