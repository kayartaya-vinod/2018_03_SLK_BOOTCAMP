package com.slk.training.dao;

import com.slk.training.model.Person;

public interface PersonDao {

	// CRUD OPERATIONS
	public void add(Person person) throws DaoException;
	
	public Person get(Integer id) throws DaoException;
	
	public void update(Person person) throws DaoException;
	
	public void delete(Integer id) throws DaoException;
	
	// QUERIES (to be done later)
}
