package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.slk.training.util.DbUtil;
import com.slk.training.util.KeyboardUtil;

public class P18_ResultSetDemo {
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from persons where id =?");
		int id = KeyboardUtil.getInt("Enter id: ");
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			System.out.println("Name  = " + rs.getString("name"));
			System.out.println("Email = " + rs.getString("email"));
			System.out.println("Phone = " + rs.getString("phone"));
		}
		else {
			System.out.println("No data found for id " + id);
		}
		
		
		rs.close();
		stmt.close();
		conn.close();
	}

}
