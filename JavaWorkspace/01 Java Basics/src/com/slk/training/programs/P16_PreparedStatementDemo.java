package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.slk.training.util.DbUtil;
import com.slk.training.util.KeyboardUtil;

public class P16_PreparedStatementDemo {

	public static void main(String[] args) throws Exception {
		
		String name, email, phone, ans;
		
		Connection conn  = DbUtil.getConnection();
		String sql = "insert into persons values (null, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		while(true) {
			name = KeyboardUtil.getString("Enter name        : ");
			email = KeyboardUtil.getString("Enter email id    : ");
			phone = KeyboardUtil.getString("Enter phone number: ");
			
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, phone);

			stmt.executeUpdate();
			
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
