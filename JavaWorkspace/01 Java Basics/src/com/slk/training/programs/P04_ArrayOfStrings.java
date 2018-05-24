package com.slk.training.programs;

import java.util.Arrays;

public class P04_ArrayOfStrings {
	public static void main(String[] args) {

		String[] names;
		names = new String[4];

		names[0] = "Vinod";
		names[1] = "Shyam";
		names[2] = "Arun";
		names[3] = "Dayanand";

		int nums[] = { 12, 39, 9, 33, 392, 22 };
		System.out.println("The numbers are: " + Arrays.toString(nums));

		System.out.println("The names are: " + Arrays.toString(names));
		Arrays.sort(names);
		System.out.println("Names in alphabatical order: " + Arrays.toString(names));

		names = "Ramesh;Kiran;Naveen;James".split(";");
		System.out.println("The names are: " + Arrays.toString(names));

		String[] days = "Sunday_Monday_Tuesday_Wednessday_Thursday_Friday_Saturday".split("_");
		System.out.println(Arrays.toString(days));

		days = "Sunday_Monday_Tuesday_Wednessday_Thursday_Friday_Saturday".split("_");
		System.out.println(Arrays.toString(days));

		days = "Sunday Monday             Tuesday	Wednessday Thursday Friday Saturday".split("day\\s*");
		System.out.println(Arrays.toString(days));

	}
}
