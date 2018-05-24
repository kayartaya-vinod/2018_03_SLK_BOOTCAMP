package com.slk.training.programs;

public class P08_ExceptionBasics {

	public static void main(String[] args) {

		try {
			int n1, n2;
			n1 = Integer.parseInt(args[0]);
			n2 = Integer.parseInt(args[1]);

			int q = n1 / n2;

			System.out.printf("The quotient of %d / %d is %d\n", n1, n2, q);
		} catch (ArithmeticException | NumberFormatException e) {
			System.out.println("Invalid number or cannot divide by zero!");
		} catch (Exception e) {
			System.out.println("There's an error!");
		}

		System.out.println("End of main!");
	}
}
