package spring.training.programs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.training.cfg.AppConfig2;
import spring.training.entity.Product;

public class P07_JdbcTemplateDemo {
	private static JdbcTemplate template;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);

		template = ctx.getBean(JdbcTemplate.class);

		printProductCount();
		printProductNameById(10); // 10 -> product_id
		printProductDetails(10); // 10 -> product_id
		printProductsByPriceRange(50.0, 200.0); // min->50, max->200
		
		getProductById(10); // 10 -> product_id
		getProductsByCategory(1); // 1 -> category_id
		ctx.close();
	}
	
	static void getProductsByCategory(int categoryId) {
		String sql = "select * from products where category_id = ?";
		List<Product> list = template.query(sql, new ProductRowMapper(), categoryId);
		
		for(Product p: list) {
			System.out.println(p.getProductName() + " --> $" + p.getUnitPrice());
		}
		printLine();
	}

	static void getProductById(int id) {
		String sql = "select * from products where product_id = ?";
		Product p = template.queryForObject(sql, new ProductRowMapper(), id);
		System.out.println("Name = " + p.getProductName());
		System.out.println("Price = $" + p.getUnitPrice());
		System.out.println("Desc = " + p.getQuantityPerUnit());
		System.out.println(p);
		printLine();
	}

	static class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p = new Product();
			p.setProductId(rs.getInt("product_id"));
			p.setProductName(rs.getString("product_name"));
			p.setSupplierId(rs.getInt("supplier_id"));
			p.setCategoryId(rs.getInt("category_id"));
			p.setUnitPrice(rs.getDouble("unit_price"));
			p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
			p.setUnitsInStock(rs.getInt("units_in_stock"));
			p.setUnitsOnOrder(rs.getInt("units_on_order"));
			p.setReorderLevel(rs.getInt("reorder_level"));
			p.setDiscontinued(rs.getInt("discontinued"));
			return p;
		}
	}

	static void printProductsByPriceRange(double min, double max) {
		String sql = "select * from products where unit_price between ? and ? order by unit_price";
		List<Map<String, Object>> list = template.queryForList(sql, min, max);
		for(Map<String, Object> data: list) {
			System.out.printf("%s --> $%.2f\n", data.get("product_name"), data.get("unit_price"));
		}
		printLine();
	}

	static void printProductDetails(int id) {
		// use queryForMap when the SQL returns 1 row multiple columns
		
		String sql = "select * from products where product_id = ?";
		Map<String, Object> data = template.queryForMap(sql, id);
		System.out.println("Name = " + data.get("product_name"));
		System.out.println("Price = $" + data.get("unit_price"));
		System.out.println("Desc = " + data.get("quantity_per_unit"));
		System.out.println(data);
		printLine();
	}

	static void printProductNameById(int id) {
		String sql = "select product_name from products where product_id = ?";
		String productName = template.queryForObject(sql, String.class, id);
		System.out.println("Product Name = " + productName);
		printLine();
	}

	static void printProductCount() {
		// use queryForObject only when the SQL query returns 1 row 1 column
		int pc = template.queryForObject("select count(*) from products", Integer.class);
		System.out.println("Product count = " + pc);
		printLine();
	}

	static void printLine() {
		System.out.println("------------------------------------------");
	}
}


