package com.slk.training.programs;

import java.util.Set;
import java.util.TreeSet;

import com.slk.training.model.Person;

public class P22_SetDemo {

	public static void main(String[] args) {
		
		Integer n1, n2;
		n1 = new Integer(100);
		n2 = new Integer(100);
		System.out.println("n1==n2 is "  + (n1==n2));
		System.out.println("n1.hashCode = " + n1.hashCode());
		System.out.println("n2.hashCode = " + n2.hashCode());
		
		
		Set<Integer> nums = new TreeSet<Integer>();
		nums.add(n1);
		nums.add(n2);
		nums.add(1200);
		nums.add(33);
		nums.add(49);
		nums.add(12);
		nums.add(100);
		nums.add(-12);
		nums.add(3000);
		
		System.out.println("nums.size = " + nums.size());
		System.out.println(nums);
		
		Set<Person> people = new TreeSet<Person>();
		Person p1 = new Person("Vinod", "vinod@vinod.co", null);
		Person p2 = new Person("Vinodh", "vinod@vinod.co", null);
		System.out.println("p1==p2 is " + (p1==p2));
		System.out.println("p1.hashCode is " + p1.hashCode());
		System.out.println("p2.hashCode is " + p2.hashCode());
		
		people.add(p1);
		people.add(p2);
		people.add(new Person("Ramesh", "ramesh@vinod.co", null));
		people.add(new Person("Ramesh", "ramesh@example.com", null));
		people.add(new Person("Ramesh", "ramesh@vinod.co", null));
		people.add(new Person("Suresh", "suresh@vinod.co", null));
		people.add(new Person("Suresh", "suresh@vinod.co", null));
		people.add(new Person("Suresh", "suresh@vinod.co", null));
		people.add(new Person("Vinod", "vinod@vinod.co", null));
		people.add(new Person("Vinod", "vinod@vinod.co", null));
		people.add(new Person("Harish", "harish@vinod.co", null));
		System.out.println("people.size = " + people.size());
		
		for(Person p: people) {
			System.out.println(p);
		}
		
		
	}
}







