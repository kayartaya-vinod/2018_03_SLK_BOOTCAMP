package com.slk.training.programs;

import java.util.Arrays;

import com.slk.training.entity.Person;

public class P05_ArrayOfPerson {
	public static void main(String[] args) {

		// people is an array of 10 Person "references" not objects!
		Person[] people = new Person[10];

		System.out.println("People = " + Arrays.toString(people));

		// Currently people[0] is null, and anything accessed using a null reference
		// cause an object of NullPointerException being thrown; which breaks the
		// execution of the application

		// String aName = people[0].getName();
		// System.out.println("aName = " + aName);

		people[0] = new Person("Vinod", "vinod@vinod.co", "9731424784");
		people[1] = new Person("John", "john@example.com", "5559383222");
		people[2] = new Person("Smith", "smith@example.com", "5551183222");

		for (int i = 0; i < people.length; i++) {

			Person p = people[i];
			if (p != null) {
				System.out.println(p);
			}

		}

	}
}
