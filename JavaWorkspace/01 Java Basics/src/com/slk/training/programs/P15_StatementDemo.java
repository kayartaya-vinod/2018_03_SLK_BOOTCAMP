package com.slk.training.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.slk.training.util.DbUtil;
import com.slk.training.util.KeyboardUtil;

public class P15_StatementDemo {

	public static void main(String[] args) throws Exception {
		
		String name, email, phone, ans;
		
		Connection conn  = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		while(true) {
			name = KeyboardUtil.getString("Enter name        : ");
			email = KeyboardUtil.getString("Enter email id    : ");
			phone = KeyboardUtil.getString("Enter phone number: ");
			
			String sql = "insert into persons values(null, '" 
					+ name + "', '" + email + "', '" + phone + "')";
			
			stmt.executeUpdate(sql);
			
			ans = KeyboardUtil.getString("Do you want to add another (yes/no): ");
			if(ans.equals("no")) {
				break;
			}
		}
		stmt.close();
		conn.close();
		
		System.out.println("Thank you for using this app!");
		
		
		
	}
}
