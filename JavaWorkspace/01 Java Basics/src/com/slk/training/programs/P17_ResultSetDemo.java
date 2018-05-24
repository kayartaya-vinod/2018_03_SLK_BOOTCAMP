package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.slk.training.util.DbUtil;

public class P17_ResultSetDemo {
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from persons");
		ResultSet rs = stmt.executeQuery();
		
		System.out.println("Id Name                 Email                          Phone");
		System.out.println("---------------------------------------------------------------------");
		while(rs.next()) {
			System.out.printf("%2d %-20s %-30s %-15s\n", 
					rs.getInt(1),
					rs.getString(2), 
					rs.getString(3), 
					rs.getString(4));
		}
		System.out.println("---------------------------------------------------------------------");
		
		rs.close();
		stmt.close();
		conn.close();
	}

}
