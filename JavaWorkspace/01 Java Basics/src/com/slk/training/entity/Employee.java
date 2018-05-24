package com.slk.training.entity;

import com.slk.training.exceptions.InvalidIdException;
import com.slk.training.exceptions.InvalidNameException;
import com.slk.training.exceptions.InvalidSalaryException;

public class Employee {
	private int id;
	private String name;
	private double salary;

	public Employee() {
	}

	public Employee(int id, String name, double salary) throws Exception {
		setId(id);
		setName(name);
		setSalary(salary);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws InvalidIdException {
		if (id <= 0) {
			throw new InvalidIdException("ID must be >0");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws InvalidNameException {
		int len = name.trim().length();
		if (len == 0 || len > 20) {
			throw new InvalidNameException("Name must have max of 20 letters, and cannot be empty!");
		}
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws InvalidSalaryException {
		if (salary < 15000 || salary > 1000000) {
			throw new InvalidSalaryException("Salary must be between Rs.15000 and Rs.1000000");
		}
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
