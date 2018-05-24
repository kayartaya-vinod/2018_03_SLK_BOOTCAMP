package com.slk.training.assignments;

public class NumberToWords {

	public static void main(String[] args) {
		int num;
		String words;
		
		num = 123456789; // 12, 34, 56, 7, 89
		words = inWords(num);
		System.out.println(num + " --> " + words);

		num = 17;
		words = inWords(num);
		System.out.println(num + " --> " + words);


		num = 12345;
		words = inWords(num);
		System.out.println(num + " --> " + words);

		num = 10100011;
		words = inWords(num);
		System.out.println(num + " --> " + words);

		num = 12390033;
		words = inWords(num);
		System.out.println(num + " --> " + words);

		num = 10000001;
		words = inWords(num);
		System.out.println(num + " --> " + words);

	}

	public static String inWords(int num) {

		if (num > 999999999) {
			throw new RuntimeException("Number too big; must be <= 999999999");
		}
		if (num < 0) {
			throw new RuntimeException("Number is not positive!");
		}

		if (num == 0)
			return "zero";

		String str = "";

		
		String[] a3 = {"", "hundred", "thusand", "lakh", "crore" };
		
		int[] nums = new int[5];
		int index = 0;
		
		while (num>0) {
			if(index==1) {
				nums[index] = num%10;
				num /= 10;
			}
			else {
				nums[index] = num%100;
				num /= 100;
			}
			index++;
		}
		index--;
		
		while(index>=0) {
			int n = nums[index];
			if(n>0) {
				String word = getWord(nums[index]);
				word += " ";
				word += a3[index];
				word += " ";
				str += word;
			}
			index--;
		}
		
		
		return str;
	}
	
	private static String getWord(int num) {
		String[] a1 = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		String[] a2 = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		
		if(num<20) {
			return a1[num];
		}
		
		int a, b;
		a = num%10;
		b = num/10;
		return a2[b] + " " + a1[a];
		
	}
}













