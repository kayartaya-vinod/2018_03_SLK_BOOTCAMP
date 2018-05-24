package com.slk.training.assignments;

import java.util.Scanner;

public class SumOfInputs {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		String numericals, nonNumericals;
		numericals = "";
		nonNumericals = "";
		double sum = 0;
		int vc = 0, ic = 0;

		while (true) {
			System.out.print("Enter a number (0 to stop): ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			try {
				double num = Double.parseDouble(input);
				if (num == 0)
					break;
				vc++;
				numericals += input + ", ";
				sum += num;
			} catch (Exception e) {
				nonNumericals += input + ", ";
				ic++;
			}
		}

		System.out.println("Sum = " + sum);
		System.out.println("Count of numbers = " + vc);
		System.out.println("Count of non-numericals = " + ic);
		System.out.println("Input numbers = " + numericals);
		System.out.println("Non numbers = " + nonNumericals);
	}
}
