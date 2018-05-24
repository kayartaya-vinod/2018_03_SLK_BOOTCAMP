package com.slk.training.programs;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class P24_ReadFromFile {
	static String filename = "/Users/vinodkumar/Documents/classroom_demos/SLK_BOOTCAMP_MAR_2018/JavaWorkspace/01 Java Basics/src/com/slk/training/programs/P04_ArrayOfStrings.java";

	@SuppressWarnings("deprecation")
	public static void main(String[] args)throws Exception {
		FileInputStream file = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(file);
		String line;
		int loopCount = 0;
		// as of JDK1.1, DataInputStream.readLine() is deprecated
		// use BufferedReader.readLine() instead.
		while((line = in.readLine())!=null) {
			System.out.println(line);
			loopCount++;
		}
		System.out.println("Loop count = " + loopCount);
		in.close();
		file.close();
	}
	public static void main_2(String[] args) throws Exception {
		FileInputStream file = new FileInputStream(filename);
		int size = file.available();
		byte[] bytes = new byte[size];
		// System.out.println(Arrays.toString(bytes));
		file.read(bytes);
		// System.out.println(Arrays.toString(bytes));
		file.close();
		String data = new String(bytes);
		System.out.println(data);
	}

	public static void main_1(String[] args) throws Exception {

		FileInputStream file = new FileInputStream(filename);
		int ch;
		int count = 0;
		while ((ch = file.read()) != -1) {
			System.out.print((char) ch);
			count++;
		}
		file.close();
		System.out.println("Loop count = " + count);
	}
}
