package com.slk.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.slk.training.dao.DaoException;
import com.slk.training.dao.PersonDao;
import com.slk.training.model.Person;
import com.slk.training.util.DbUtil;

public class PersonDaoJdbcImpl implements PersonDao {

	@Override
	public void add(Person person) throws DaoException {
		if(person==null) {
			throw new DaoException("Person object is null!");
		}
		
		String sql = "insert into persons values(null, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, person.getName());
			stmt.setString(2,  person.getEmail());
			stmt.setString(3, person.getPhone());
			stmt.executeUpdate(); // for DML
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, null);
		}
	}

	@Override
	public Person get(Integer id) throws DaoException {
		if(id==null) { 
			throw new DaoException("ID cannot be null!");
		}
		if(id<0) {
			throw new DaoException("ID cannot be negative");
		}
		String sql = "select * from persons where id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery(); // SELECT
			if(rs.next()) {
				Person p = new Person();
				p.setId(id);
				p.setName(rs.getString("name"));
				p.setEmail(rs.getString("email"));
				p.setPhone(rs.getString("phone"));
				return p;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public void update(Person person) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub

	}

}
