package com.slk.training.programs;

abstract class Animal {
	public abstract void whoAmI();

	public void talk() {
		System.out.println("Animal talking...");
	}
}

class Cat extends Animal {
	@Override
	public void talk() {
		System.out.println("This is me talking...Meow, meow");
	}

	@Override
	public void whoAmI() {
		System.out.println("I am a Cat!");
	}
	
	public void furr() {
		System.out.println("Furrr....!");
	}
}

class Dog extends Animal {

	@Override
	public void whoAmI() {
		System.out.println("I am a Dog");
	}

	@Override
	public void talk() {
		System.out.println("This is me takking...Bow, bow.");
	}
	
	public void wagTail() {
		System.out.println("Tail wagging...");
	}
	
}

public class P07_InheritanceDemo {
	public static void main(String[] args) {

		Animal a1;
		// a1 = new Animal(); 
		// the class Animal is abstract (incomplete) and can not be
		// used for the manufacturing of an object
		
		a1 = new Cat(); // Cat (subtipe) is cast to an Animal (supertype)
		// hence it is termed as UPCASTING, which is implicitly done.
		a1.talk();
		
		a1 = new Dog();
		a1.talk();
		
		// if you wish to use the subtype specific functionalities, 
		// then cast it to a subtype variable and use the same
		if(a1 instanceof Dog) {
			Dog d1;
			d1 = (Dog) a1; // Animal variable cast to a subtype (Dog), 
			// Downcasting; need to be explicitly (and conditionally) done.
			d1.wagTail();
		}
		else if(a1 instanceof Cat) {
			Cat c1 = (Cat) a1;
			c1.furr();
		}

	}
}
