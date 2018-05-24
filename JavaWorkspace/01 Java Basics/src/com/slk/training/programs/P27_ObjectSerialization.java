package com.slk.training.programs;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.slk.training.model.Person;

public class P27_ObjectSerialization {

	public static void main(String[] args) throws Exception {
		deserializePersonObjects();
	}

	public static void deserializePersonObjects() throws Exception {
		String filename = "people.data";
		FileInputStream file = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(file);

		while (true) {
			try {
				Object obj = in.readObject();
				if (obj instanceof Person) {
					Person p = (Person) obj;
					System.out.println("Name  = " + p.getName());
					System.out.println("Email = " + p.getEmail());
					System.out.println("Phone = " + p.getPhone());
					System.out.println("------------------------");
				}
			} catch (EOFException e) {
				break;
			}
		}
		in.close();
		file.close();
	}

	public static void serializePersonObjects() throws Exception {
		String filename = "people.data";

		Person[] people = { new Person("Vinod", "vinod@vinod.co", "9731424784"),
				new Person("Shyam", "shyamkc@gmail.com", "9731424722"),
				new Person("John Doe", "john@example.com", "5551424784"),
				new Person("Jane Doe", "jane@exmaple.com", "5551424788") };

		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(file);

		for (Person p : people) {
			out.writeObject(p);
		}

		out.close();
		file.close();
		System.out.println("Data written to people.data file!");
	}
}
