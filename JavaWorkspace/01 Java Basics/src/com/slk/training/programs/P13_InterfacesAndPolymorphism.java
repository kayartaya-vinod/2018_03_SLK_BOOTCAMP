package com.slk.training.programs;

interface Shape {
	double PI = 3.1416; // variables become -> public, static and final

	void printArea(); // functions become -> public and abstract
}

class Rectangle implements Shape {
	// implementing an interface is equivalent to extending an abstract class
	// which contains only abstract functions; which insists that this class
	// implements all the abstract inherited methods

	private double width, breadth;

	public Rectangle() {
	}

	public Rectangle(double width, double breadth) {
		this.width = width;
		this.breadth = breadth;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	// while overriding the methods, the visibility can only be increased but
	// not decreased; private->default->protected->public
	@Override
	public void printArea() {
		double area = width * breadth;
		System.out.printf("Area of rectangle (%.2fX%.2f) is %.2f\n", width, breadth, area);
	}

}

class Sphere implements Shape {

	private double radius;

	public Sphere() {
	}

	public Sphere(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void printArea() {
		double area = Sphere.PI * radius * radius * 4;
		System.out.printf("Area of sphere of radius %.2f is %.2f\n", radius, area);
	}

}

public class P13_InterfacesAndPolymorphism {
	
	static void printShapeDetails(Shape sh) {
		System.out.println("'sh' is a : " + sh.getClass().getName());
		System.out.print("Area of 'sh' is : ");
		sh.printArea();
		System.out.println();
	}

	public static void main(String[] args) {
		Sphere sp1 = new Sphere(2.3);
		Rectangle r1 = new Rectangle(2.3, 4.5);
		
		printShapeDetails(r1);
		printShapeDetails(sp1);
		
	}
}










