package com.slk.training.programs;

import com.slk.training.entity.Address;
import com.slk.training.entity.Person;

public class P06_AggregationDemo {

	public static void main(String[] args) {

		Person p = new Person("Vinod", "vinod@vinod.co", "9731424784");
		p.setAddress(new Address("TF1 Elegant Elite", "1st cross 1st main", "ISRO Layout"));

		p.print();

	}
}
