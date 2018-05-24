package com.slk.training.programs;

import com.slk.training.entity.Employee;
import com.slk.training.exceptions.InvalidIdException;
import com.slk.training.exceptions.InvalidNameException;
import com.slk.training.exceptions.InvalidSalaryException;

public class P11_CustomExceptions {

	public static void main(String[] args) {
		
		Employee e1;
		e1 = new Employee();
		
			try {
				e1.setName("Mike");
				e1.setId(22);
				e1.setSalary(30000);
			} catch (InvalidNameException e) {
				System.out.println("There was problem with name");
			} catch (InvalidIdException e) {
				System.out.println("There was a problem with id");
			} catch (InvalidSalaryException e) {
				System.out.println("There was a problem with salary");
			}
		
		
		System.out.println(e1);
		
	}
}
