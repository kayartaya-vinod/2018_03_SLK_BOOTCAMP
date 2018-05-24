package com.slk.training.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P14_JdbcDemo {
	
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/slk_training";
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "root";
		
		// url = "jdbc:h2:tcp://localhost/~/slk_training";
		// driver = "org.h2.Driver";
		
		// Step #1: load the JDBC Driver class provided by the DB vendor
		// Class.forName(driver);
		// By loading a JDBC Driver class into the VM, the Driver class
		// instantiates itself and registers the same with DriverManager
		Class.forName(driver);
		
		
		// Step #2: establish connection to the database
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Got a connection of type: " + conn.getClass());
		
		// Statement instance is capable of sending SQL commands to the server,
		// and get data from the same.
		Statement stmt = conn.createStatement();
		System.out.println("Got a statement of type: " + stmt.getClass());
		
		String sql = "create table if not exists persons(id int primary key auto_increment, ";
		sql += "name varchar(50), email varchar(50), phone varchar(50))";
		
		stmt.execute(sql);
		
		stmt.close();
		conn.close();
		
		System.out.println("Table persons created!");
	}

}









