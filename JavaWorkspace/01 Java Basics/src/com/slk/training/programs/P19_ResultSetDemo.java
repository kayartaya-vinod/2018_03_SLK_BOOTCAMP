package com.slk.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.slk.training.util.DbUtil;
import com.slk.training.util.KeyboardUtil;

public class P19_ResultSetDemo {

	public static void main(String[] args) throws Exception {

		Connection conn = DbUtil.getConnection("northwind");
		String sql = "select product_name, unit_price, units_in_stock from products where category_id = ? and unit_price between ? and ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		int catId = KeyboardUtil.getInt("Enter category id (1 to 8): ");
		double minPrice = KeyboardUtil.getDouble("Enter min price: ");
		double maxPrice = KeyboardUtil.getDouble("Enter max price: ");

		stmt.setInt(1, catId);
		stmt.setDouble(2, minPrice);
		stmt.setDouble(3, maxPrice);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String pname = rs.getString(1); // rs.getString("product_name");
			double price = rs.getDouble(2); // rs.getDouble("unit_price");
			double pcount = rs.getInt(3); // rs.getInt("units_in_stock");

			System.out.println(pname + ", $" + price + " (" + pcount + " units)");
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
