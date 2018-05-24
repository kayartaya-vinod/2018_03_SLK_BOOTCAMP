package com.slk.training.programs;

public class P03_UsingArrays {

	public static void main(String[] args) {

		int[] nums = { 10, 20, 22, 39, 58, 33 };
		System.out.println("Number of elements in the array nums = " + nums.length);
		System.out.println("The numbers are: ");
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}
}
