package com.slk.training.programs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.slk.training.model.Person;

public class P21_ListDemo {

	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<Integer>();
		nums.add(100);
		nums.add(22);
		nums.add(44);

		System.out.println(nums);

		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Vinod", "vinod@vinod.co", null));
		people.add(new Person("Ramesh", "ramesh@vinod.co", null));
		people.add(new Person("Suresh", "suresh@vinod.co", null));
		people.add(new Person("Vinod", "vinod@vinod.co", null));
		people.add(new Person("Vinod", "vinod@vinod.co", null));
		people.add(new Person("Harish", "harish@vinod.co", null));
		
		// method#1
		for (int i = 0, j = people.size(); i < j; i++) {
			Person p1 = people.get(i);
			System.out.println(p1);
		}
		System.out.println("------------------------------");
		// method#2: enhanced for loop (for-each loop)
		for(Person p1: people) {
			System.out.println(p1);
		}
		System.out.println("------------------------------");
		// method#3: using iterator
		Iterator<Person> it = people.iterator();
		while(it.hasNext()) {
			Person p1 = it.next();
			System.out.println(p1);
		}
		
	}

}








