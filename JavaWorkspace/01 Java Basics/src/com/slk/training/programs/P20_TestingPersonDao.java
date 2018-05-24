package com.slk.training.programs;

import com.slk.training.dao.DaoException;
import com.slk.training.dao.PersonDao;
import com.slk.training.dao.impl.PersonDaoJdbcImpl;
import com.slk.training.model.Person;

public class P20_TestingPersonDao {
	
	public static void main(String[] args) {
		PersonDao dao = new PersonDaoJdbcImpl();
		
		Integer id = 2;
		try {
			Person p = dao.get(id);
			if(p==null) {
				System.out.println("No data found for id: " + id);
			}
			else {
				System.out.println("Name   = " + p.getName());
				System.out.println("Email  = " + p.getEmail());
				System.out.println("Phone  = " + p.getPhone());
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		// testAddPerson(dao);
		
	}

	static void testAddPerson(PersonDao dao) {
		Person p1 = new Person("Suresh", "suresh@example.com", "9879876541");
		try {
			dao.add(p1);
			System.out.println("Suresh's record added to the DB");
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
