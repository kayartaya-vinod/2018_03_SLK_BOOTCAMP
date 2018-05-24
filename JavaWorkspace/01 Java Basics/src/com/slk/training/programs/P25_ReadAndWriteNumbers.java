package com.slk.training.programs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.slk.training.util.KeyboardUtil;

// read and write binary data
public class P25_ReadAndWriteNumbers {

	static String filename = "numbers.data";

	static void writeNums() throws Exception {
		FileOutputStream file = new FileOutputStream(filename, true);
		DataOutputStream out = new DataOutputStream(file);
		double input;
		while(true) {
			input = KeyboardUtil.getDouble("Enter a number (0 to stop): ");
			if(input==0) {
				break;
			}
			out.writeDouble(input);
		}
		out.close();
		file.close();
	}

	static void readNums() throws Exception {
		FileInputStream file = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(file);
		while(true) {
			try {
				double d = in.readDouble();
				System.out.println(d);
			} catch (EOFException e) {
				break;
			}
		}
		in.close();
		file.close();
	}

	static int menu() {
		int choice = 0;
		do {
			System.out.println("1. Write numbers");
			System.out.println("2. Read numbers");
			System.out.println("3. Exit");
			choice = KeyboardUtil.getInt("Enter your choice >> ");
		} while (choice < 1 || choice > 3);
		return choice;
	}

	public static void main(String[] args) throws Exception {
		int choice;
		while ((choice = menu()) != 3) {
			switch (choice) {
			case 1:
				writeNums();
				break;
			case 2:
				readNums();
				break;
			}
		}
		System.out.println("Thank you for using this app!");
	}

}
